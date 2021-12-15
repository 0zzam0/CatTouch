package com.example.cattouch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cattouch.databinding.ActivityMainBinding
import com.example.cattouch.databinding.ActivityMain2Binding
import com.example.cattouch.databinding.ActivityMain3Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider


var count :Int =0
var touch = false


class MainActivity : AppCompatActivity() , View.OnClickListener {
    //firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth

    //google client
    private lateinit var googleSignInClient: GoogleSignInClient

    private val RC_SIGN_IN = 99
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:ArrayAdapter<String>
    var name: String = ""
    var address: String = ""
    var password: String = ""
    var country: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 초기화 (import 단축키 Alt + Enter)
        //초기화 위해서 build.gradle -> android에 viewBinding true 추가하기
        binding = ActivityMainBinding.inflate(layoutInflater)
        //레이아웃 표시
        setContentView(binding.root);
        //배열 가져오기
        val sData = resources.getStringArray(R.array.country)
        //어댑터로 연결
        adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sData)
        binding.spinnerCountry.adapter = adapter
        //세팅
        binding.spinnerCountry.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //TODO("Not yet implemented")
                    country = binding.spinnerCountry.getSelectedItem().toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //TODO("Not yet implemented")
                }
            }
        //텍스트
        binding.Address.setText("Address")
        binding.Name.setText("Name")
        binding.Password.setText("Password")





        //구글 로그인
        binding.btnGoogleSignIn.setOnClickListener { signIn()}

        //로그인 옵션 구성(GoogleSignOptions에서 GoogleApiClient를 위한 옵션 지정)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            //getString(R.string.default_web_client_id), values.xml
            .requestIdToken("430686827206-lmf2tsacm6evk492k9ihl7si937op6v2.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)

        //firebase auth 객체
        firebaseAuth = FirebaseAuth.getInstance()



    }

    public override fun onStart(){
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account != null){
           toMainActivity(firebaseAuth.currentUser)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            }
            catch(e : ApiException){
                //sign in falied
                Log.w("LoginActivity", "Google sign in failed",e )
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount){
        Log.d("LoginActivity", "firebaseAuthWithGoogle:" + acct.id!!)

        //Google SignInAcoount 객체에서 ID 토큰을 가져와서 firebase auth로 교환하고 firebase에 인증
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 성공", task.exception)
                    toMainActivity(firebaseAuth?.currentUser)
                }
                else{
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 실패", task.exception)
                    Toast.makeText(this.applicationContext, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
            }

    }

    fun toMainActivity(user: FirebaseUser?){
        if(user != null){
            startActivity(Intent(this, MainActivity3::class.java))
            finish()
        }
    }

    private fun signIn(){
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun signOut() {
        firebaseAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }
    }

    private fun revokeAccess(){
        firebaseAuth.signOut()
        googleSignInClient.revokeAccess().addOnCompleteListener(this){

        }
    }

    override fun onClick(v: View?) {
        //TODO("Not yet implemented")
    }


}





