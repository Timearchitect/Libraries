package se.gritacademy.libraries

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.JSONValue


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val s = "[2000,{\"1\":5000}]"
        val obj = JSONValue.parse(s)
        val array: JSONArray = obj as JSONArray
        val obj2: JSONObject =  array.get(1) as JSONObject
        Log.i("alrik", "onCreate: "+ array.get(0));
        Log.i("alrik", "onCreate: "+ array.get(1).toString());
        Log.i("alrik", "onCreate2: "+ obj2.get("1"));
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Log.i("alrik", "onItemSelected: "+ position)


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}