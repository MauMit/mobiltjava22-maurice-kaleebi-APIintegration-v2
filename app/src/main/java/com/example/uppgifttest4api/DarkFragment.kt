package com.example.uppgifttest4api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser

class DarkFragment : Fragment() {

    private lateinit var rq: RequestQueue
    private val url = "https://v2.jokeapi.dev/joke/Dark?format=json"
    private lateinit var response: JSONObject

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dark, container, false)
        val textDark = view.findViewById<TextView>(R.id.textDark)
        val buttonDark = view.findViewById<Button>(R.id.buttonDark)

        rq = Volley.newRequestQueue(requireContext())

        buttonDark.setOnClickListener {
            val r = StringRequest(
                Request.Method.GET, url,
                { res ->
                    val parser = JSONParser()
                    val obj: Any? = parser.parse(res as String)
                    response = obj as JSONObject

                    if (response.containsKey("setup") || response.containsKey("delivery")) {
                        textDark.text = " ${response["setup"]} \n  ${response["delivery"]}"
                    } else {
                        textDark.text = "${response["joke"]}"
                    }

                    Log.d("Hello2", res.toString())
                },
                { err -> Log.d("Maurice", err.toString()) }
            )
            rq.add(r)
        }
        return view
    }
}