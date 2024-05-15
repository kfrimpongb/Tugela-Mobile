package extensions

import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.tugela.data.models.responses.ApiResponse
import com.tugela.util.network.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException


fun <T> makeNetworkRequest(dispatcher: CoroutineDispatcher = Dispatchers.IO,
                      request: suspend () -> ApiResponse<T>
): Flow<DataState<T>> {
    return flow {
        try {
            emit(DataState.Loading)
            val apiResponse = request.invoke()
            emit(DataState.Success(apiResponse.data))

        } catch (e: HttpException) {
            val body = e.response()?.errorBody()
//            val message = e.response()?.message()
            val rawResponse = e.response()?.raw()
            val code = e.response()?.code()
            val gson = GsonBuilder().setLenient().create()

            try {
                val apiResponse = gson.fromJson(body?.charStream(), ApiResponse::class.java)

                Timber.tag("requestException").d("errorCode : $code")
                Timber.tag("requestException").e("Timber: ${request.javaClass.enclosingMethod?.name} --> ${e.javaClass} \n --> $apiResponse")
            } catch (e: Exception) {
                val errorMessage = "Timber: ${request.javaClass.enclosingMethod?.name} --> ${e.javaClass} --> \n ${e.localizedMessage} \n--> $rawResponse"
                Timber.tag("requestException").e(errorMessage)
                emit(DataState.Error(Exception("")))
            }

        }
        catch (e: UnknownHostException){
            Timber.tag("requestException").e("$e")
            emit(DataState.Error(Exception("Please check your internet connection and try again")))
        }
        catch (e: IOException) {
            Timber.tag("requestException").e("$e")
            emit(DataState.Error(Exception("Check your internet and try again.")))
        }
        catch (e: JsonSyntaxException) {
            val errorMessage = "Timber: ${request.javaClass.enclosingMethod?.name} --> ${e.javaClass} --> \n ${e.localizedMessage}"
            Timber.tag("requestException").e(errorMessage)

            emit(DataState.Error(Exception("")))
        }
    }.flowOn(dispatcher)
}