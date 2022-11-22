package com.example.uploadimage

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import net.gotev.uploadservice.MultipartUploadRequest
import java.io.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener {

     lateinit var buttonChoose: Button
    lateinit var buttonUpload: Button
    private var imageView: ImageView? = null
    private var editText: EditText? = null

    //Image request code
    private val PICK_IMAGE_REQUEST = 1

    //storage permission code
    private val STORAGE_PERMISSION_CODE = 123

    //Bitmap to get image from gallery
    private var bitmap: Bitmap? = null

    //Uri to store the image uri
    private var filePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestStoragePermission()

        buttonChoose =  findViewById(R.id.buttonChoose)
        buttonUpload = findViewById(R.id.buttonUpload)
        imageView =  findViewById(R.id.imageView)
        editText =  findViewById(R.id.editTextName)

        buttonChoose.setOnClickListener(this)
        buttonUpload.setOnClickListener(this)


    }

    private fun requestStoragePermission()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE) , STORAGE_PERMISSION_CODE)
    }

    override fun onClick(v: View?)
    {
        if (v == buttonChoose)
        {
            showFileChooser()
        }
        if (v == buttonUpload)
        {
            uploadMultipart()
        }
    }

    private fun uploadMultipart()
    {
        val name = editText!!.text.toString().trim { it <= ' ' }

        val path: String = getPath(filePath)!!

        //Uploading code

        //Uploading code
        try
        {
            // String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            MultipartUploadRequest(this, Constants.UPLOAD_URL)
                .addFileToUpload(path, "url") //Adding file
                .addParameter("name", name) //Adding text parameter to the request
                //.setNotificationConfig(new UploadNotificationConfig())
                .setMaxRetries(2)
                .startUpload() //Starting the upload
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        } catch (exc: Exception) {
            Toast.makeText(this, exc.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showFileChooser()
    {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
    @SuppressLint("Range")
    fun getPath(uri: Uri?): String? {
        var cursor: Cursor? = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id: String = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path: String = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            try {
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imageView!!.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this,
                    "Permission granted now you can read the storage",
                    Toast.LENGTH_LONG).show()
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}