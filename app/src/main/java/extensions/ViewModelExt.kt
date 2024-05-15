package extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tugela.util.network.DataState
import com.tugela.util.network.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext


fun <T> BaseViewModel.emitFlowResults(
    liveDataObject: MutableLiveData<DataState<T>>,
    networkRequest: () -> Flow<DataState<T>>
) {
    coroutineScope.launch(Dispatchers.IO) {
        networkRequest()
            .onStart { liveDataObject.postValue(DataState.Loading) }
            .onEach {
                liveDataObject.postValue(it)
            }
            .catch {
                liveDataObject.postValue(DataState.Error(Exception(it.localizedMessage)))
            }
            .launchIn(this)

    }
}

fun <T> BaseViewModel.emitFlowResultsToEvent(
    liveDataObject: MutableLiveData<Event<DataState<T>>>,
    networkRequest: () -> Flow<DataState<T>>
) {
    coroutineScope.launch(Dispatchers.IO) {
        networkRequest()
            .onStart { liveDataObject.postValue(Event(DataState.Loading)) }
            .onEach {
                liveDataObject.postValue(Event(it))
            }
            .catch {
                liveDataObject.postValue(Event(DataState.Error(Exception(it.localizedMessage))))
            }
            .launchIn(this)

    }
}