package uz.muhsinov_dev.mohirdev_mvp_randomgenerator

import android.os.Handler
import java.util.Random

class RandomNumberModule:RandomGeneratorContract.Module {
    override fun getRandomNumber(randomNumberFinished: RandomGeneratorContract.Module.OnRandomNumberFinished) {
        Handler().postDelayed(object : Runnable{
            override fun run() {
                randomNumberFinished.numberReady(Random().nextInt(100))
            }
        },2000)

    }
}