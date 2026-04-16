package com.example.sokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.IntentSenderRequest
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        find the buttons by id
        val SignupButton = findViewById<Button>(R.id.signupBtn)
        val SigninButton = findViewById<Button>(R.id.signinBtn)

//        create the intent of the activities
        SignupButton.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
            //   =====================================
        SigninButton.setOnClickListener {
            val intent = Intent(applicationContext, SigninActivity::class.java)
            startActivity(intent)
        }
//        find the recycler view and progress bar by use of their ids
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
//        specify the Url
        val url = "https://kbenkamotho.alwaysdata.net/api/get_products"

//        import the helper

        val helper = ApiHelper(applicationContext)


//        inside of the helper class access the function load products

        helper.loadProducts(url,recyclerView, progressBar)


        // find the About button by use of its ID and have the intent
        val aboutButton = findViewById<Button>(R.id.aboutBtn)

//below is the intent to the About activity
        aboutButton.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)

        }





//



    }
}