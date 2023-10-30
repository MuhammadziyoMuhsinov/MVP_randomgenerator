package uz.muhsinov_dev.mohirdev_mvp_randomgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.muhsinov_dev.mohirdev_mvp_randomgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),RandomGeneratorContract.MainView {
    private lateinit var binding:ActivityMainBinding
    private lateinit var presenter: RandomNumberPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = RandomNumberPresenter(this)
        binding.button.setOnClickListener {
            presenter.onButtonClicked()
        }
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun setRandomNumber(number: Int) {
        binding.tv.text = "$number"
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}