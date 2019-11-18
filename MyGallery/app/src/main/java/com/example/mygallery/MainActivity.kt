package com.example.mygallery

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val REQUEST_READ_EXTERNAL_STORAGE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )) {
                    alert("사진 정보를 얻으려면 외부 저장소 권한이 필수로 필요합니다", "권한이 필요한 이유") {
                        yesButton {
                            //권한 요청
                            ActivityCompat.requestPermissions(this@MainActivity,arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_READ_EXTERNAL_STORAGE)
                        }
                        noButton {  }
                    }.show()
                }else{
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_READ_EXTERNAL_STORAGE)
            }
        }else{
            //권한 이미 허용됨
            getAllPhotos()
        }
    }

    private fun getAllPhotos() {
        //모든 사진 정보 가져오기
        val cursor = contentResolver.query(
            //컨텐츠 리졸버는 공유자료를 관리(연락처, 메시지, 멀티미디어)
            //미디어 스토어 : 공유 자료 중에서 멀티 미디어 자료 관리.
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,  //추가 확인해볼 필요 있음(projection)
            null, //쿼리문이 들어가는 곳. null이 들어가면 모든 자료를 가져옴.
            null, //조회에 대한 조건.
            MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC"
        ) //찍은 날짜 내림차순
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_READ_EXTERNAL_STORAGE -> {
                if((grantResults.isNotEmpty()
                            &&grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    getAllPhotos() //권한 허용됨
                }else{
                    //권한 거부
                    toast("권한 거부 됨")
                }
                return 
            }
        }
    }
}
