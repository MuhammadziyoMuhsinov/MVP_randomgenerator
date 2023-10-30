package uz.muhsinov_dev.mohirdev_mvp_randomgenerator

class RandomNumberPresenter(view:RandomGeneratorContract.MainView):RandomGeneratorContract.Presenter {

    var mainView : RandomGeneratorContract.MainView?=null
    val module = RandomNumberModule()

    init {
        mainView = view
    }

    override fun onButtonClicked() {
        mainView?.showProgress()
        module.getRandomNumber(object:RandomGeneratorContract.Module.OnRandomNumberFinished{
            override fun numberReady(randomNumber: Int) {
                mainView?.setRandomNumber(randomNumber)
                mainView?.hideProgress()
            }

        })
    }

    override fun onDestroy() {
       mainView = null
    }

}