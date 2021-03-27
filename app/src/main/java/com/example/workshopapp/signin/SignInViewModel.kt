package com.example.workshopapp.signin

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workshopapp.Utils
import com.example.workshopapp.localData.ApiObjDataBase
import com.example.workshopapp.localData.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {

    fun validate_login(userEmail: String, password: String, context: Application) :MutableLiveData<Int>{
        var result= MutableLiveData<Int>()
        result.value = 0
        var incomingUser = UserEntity("","", "")
        if (!userEmail.isNullOrEmpty() || !password.isNullOrEmpty()) {
            if (!Utils.validateRegistration(userEmail, password)) {
                    CoroutineScope(Dispatchers.IO).launch {
                        incomingUser= ApiObjDataBase.getDatabase(context).userObjDao().getUserByEmail(userEmail)
                    }
                if(incomingUser.email.equals(userEmail) && incomingUser.password.equals(password)) {
                    result.value = 1
                }else{
                    //Toast.makeText(context, "User doesn't exist", Toast.LENGTH_SHORT).show()
                    result.value = -1
                 }
            }else {
               // Toast.makeText(context, "Ivalid User name or password, Please try again", Toast.LENGTH_SHORT).show()
                result.value = 2
            }
        }else{
            //Toast.makeText(context, "User name and password can't be Empty", Toast.LENGTH_SHORT).show()
            result.value = -3
               }
        return result
    }

}