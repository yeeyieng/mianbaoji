package com.example.yydemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.fragment.app.Fragment


class secondClock : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_clock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tClock = view?.findViewById(R.id.textClock1) as TextClock
        val tView = view?.findViewById(R.id.textview1) as TextView
        val btn = view?.findViewById(R.id.btn_getTime) as Button
        btn.setOnClickListener(View.OnClickListener {
            tView.setText("Time: " + tClock.getText()) })
    }
}