package uz.muhsinov_dev.mohirdev_mvp_randomgenerator

interface RandomGeneratorContract {
    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setRandomNumber(number:Int)
    }
    interface Presenter {
        fun onButtonClicked()
        fun onDestroy()
    }
    interface Module {
        interface OnRandomNumberFinished{
            fun numberReady(randomNumber:Int)
        }
        fun getRandomNumber(randomNumberFinished: OnRandomNumberFinished)
    }
}