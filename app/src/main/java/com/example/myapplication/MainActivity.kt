package com.example.myapplication

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.ClipboardManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

class MainActivity : AppCompatActivity() {
    lateinit var result: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val camera= findViewById<ImageView>(R.id.imageView8)
        val erase = findViewById<ImageView>(R.id.imageView9)
        val copy = findViewById<ImageView>(R.id.imageView11)

        result= findViewById(R.id.resultTextView)

        camera.setOnClickListener{
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, 123)
            } else {
                Toast.makeText(this, "Oops Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }

        erase.setOnClickListener{
            result.setText("")
        }
        copy.setOnClickListener{
            val clipBoard= getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip= ClipData.newPlainText("Label", result.text.toString())
            clipBoard.setPrimaryClip(clip)
            Toast.makeText(this, "Copied To ClipBoard", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if(requestCode==123 && resultCode== RESULT_OK){
            val extras= data?.extras
            val bitmap= extras?.get("data") as Bitmap
            detectTextUsingML(bitmap)
        }
    }

    private fun detectTextUsingML(bitmap: Bitmap) {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        val image = InputImage.fromBitmap(bitmap, 0)

        val result = recognizer.process(image)
            .addOnSuccessListener { visionText ->
                // Task completed successfully
                // ...
                result.setText(visionText.text.toString())
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                // ...
                Toast.makeText(this, "Oops Something went wrong", Toast.LENGTH_SHORT).show()

            }
    }
}