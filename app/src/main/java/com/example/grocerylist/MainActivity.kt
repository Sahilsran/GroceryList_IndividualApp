package com.example.grocerylist

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.grocerylist.GroceryData.Companion.collectionOfInputs
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList


class GroceryData                   //Object of a class, which will be shared with CheckList Activity
{
   companion object
   {
       lateinit var collectionOfInputs: ArrayList<CharSequence>      //This will take an object   //The variable newGroceryListing, now accessable to other activity
   }
}

//data class GroceryDataHolder (var obj: GroceryData.Companion)






class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Objects
        val addItemButton = findViewById<ImageButton>(R.id.addItemButton)
        val checkListButton = findViewById<ImageButton>(R.id.listEditorButton)
        var newGroceryListing = findViewById<TextView>(R.id.allContents)    //Late Initialization

        val checkListInstance = CheckList()



            //Adds Items to the main list
        addItemButton.setOnClickListener {
            addListing()
            //checkListInstance.addUncheckedListing()       //Call function in other activity, that creates listings for unchecked
        }



            //Goes to the next activity
        checkListButton.setOnClickListener {
            val intent = Intent(
                this,
                 CheckList::class.java)

            startActivity(intent)
        }


            //Make newGroceryListing a clickable object that moves to CheckList Activity when clicked
        newGroceryListing.setOnClickListener {

            //Use this to call function in other activity, that makes listings for Checked
        }

    }







        fun addListing (): ArrayList<CharSequence>               //Adds a single item to the main list
    {
        //Objects
        val fullListLayout = findViewById<LinearLayout>(R.id.fullListLayout)
        var addItemEditText = findViewById<TextView>(R.id.addItemEditText)

        collectionOfInputs = ArrayList<CharSequence>()        //ArrayList that collects all the user inputed values

        //Get value from edit text and put it into a variable (userTextInput)
        var userTextInput = addItemEditText.text
        addItemEditText.text = userTextInput.toString()      //Need to convert to string


        //Creating a new TextView that serves as a template for listings
        var newGroceryListing = TextView (this)                              // Problem Detected, this line reinitialized the newGroceryListing variable, making the one in companion object obselete
        val parameters = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                    ViewGroup.LayoutParams.WRAP_CONTENT)
        parameters.setMargins(0, 10, 0, 10)
        newGroceryListing.layoutParams = parameters

        newGroceryListing.text = userTextInput
        newGroceryListing.textSize = 18F
        newGroceryListing.setPadding(105, 5, 40, 5)
        newGroceryListing.setTextColor(Color.parseColor("#2D6A4F"))
        newGroceryListing.setBackgroundColor((Color.parseColor("#B7E4C7")))
        fullListLayout.addView(newGroceryListing) //Adding textview to linear layout

        collectionOfInputs.add(newGroceryListing.text)     //Adds each user input into the arrayList

        return collectionOfInputs     //Sends this to OnCreate Function
    }

}

