package com.example.uppgifttest4api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import com.squareup.picasso.Picasso



class DogFragment : Fragment() {

    private lateinit var rq: RequestQueue
    private val url = "https://dog.ceo/api/breeds/image/random"
    private lateinit var response: JSONObject


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_dog, container, false)
        val dogButton = view.findViewById<Button>(R.id.dogButton)
        val dogImage = view.findViewById<ImageView>(R.id.imageView)

        rq = Volley.newRequestQueue(requireContext())

        dogButton.setOnClickListener {
            val r = StringRequest(
                Request.Method.GET, url,
                { res ->
                    val parser = JSONParser()
                    val obj: Any? = parser.parse(res as String)
                    response = obj as JSONObject

                    val imageUrl = response["message"].toString()

                    Picasso.get().load(imageUrl).into(dogImage)

                    Log.d("Hello", res.toString())
                },
                { err -> Log.d("Maurice", err.toString()) }
            )
            rq.add(r)
        }

        return view


    }
}