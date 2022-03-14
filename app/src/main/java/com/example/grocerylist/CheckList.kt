package com.example.grocerylist

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.grocerylist.GroceryData.Companion.collectionOfInputs


class CheckList : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.check_list)


        //Objects
        var checkedContents = findViewById<TextView>(R.id.checkedContents)
        var uncheckedContents = findViewById<TextView>(R.id.uncheckedContents)
        val listEditorButton = findViewById<ImageButton>(R.id.listEditorButton)

        for (i in 1..collectionOfInputs.size)
        {
            addUncheckedListing()
        }



        //Returns to Main Page
        listEditorButton.setOnClickListener {
            finish()
        }

    }


    fun addUncheckedListing ()
    {
        //Objects
        var uncheckedItemsLayout = findViewById<LinearLayout>(R.id.uncheckedItemsLayout)


        var newUncheckedListing= TextView (this)
        val parameters = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        parameters.setMargins(0, 10, 0, 10)
        newUncheckedListing.layoutParams = parameters


            newUncheckedListing.text = collectionOfInputs.toString()

            newUncheckedListing.textSize = 18F
            newUncheckedListing.setPadding(105, 5, 40, 5)
            newUncheckedListing.setTextColor(Color.parseColor("#9C191B"))
            newUncheckedListing.setBackgroundColor((Color.parseColor("#F1A7A9")))

            uncheckedItemsLayout.addView(newUncheckedListing) //Adding textview to linear layout
    }


}
