package ca.six.knew.seal_class

class MVI_Sample {
}

class HomeView {
    fun render(viewState : HomeViewState){
        when(viewState){
            Empty -> println("empty")
            is Error -> println("error : ${viewState.exception}")
            is ListResult -> println("${viewState.listB}")
        }
    }
}

sealed class HomeViewState {}
object Empty : HomeViewState()
data class Error(val exception : Exception) : HomeViewState()
data class ListResult(val listB : List<String>) : HomeViewState()

