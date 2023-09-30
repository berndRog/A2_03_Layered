package de.rogallab.mobile.ui
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.rogallab.mobile.data.repository.IUsersRepository
import de.rogallab.mobile.data.model.User
import de.rogallab.mobile.utilities.logDebug
import de.rogallab.mobile.utilities.logInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val _userRepository: IUsersRepository,
   private val _dispatcher: CoroutineDispatcher
): ViewModel()
{

   // MainScreen State
   private var _name: String = ""
   private var _email: String = ""

   // Data Binding with properties
   // <TextView id="@+id/main_tv_caption"
   //   text='@{viewModel.caption}' <-- One-Way Binding
   var caption: String = "Layered Architecture"
      private set

   // <EditText id="@+id/main_et_name"
   //   text='@={viewModel.name}' <-- Two-Way Binding
   var name: String
      get() = _name
      set(value) {
         // Avoids infinite loops.
         if (_name != value) {
            logDebug(tag, value)
            _name = value
         }
      }

   // <EditText id="@+id/main_et_email"
   //   text='@={viewModel.email}' <-- Two-Way Binding
   var email: String
      get() = _email
      set(value) {
         if (_email != value) {
            logDebug(tag, value)
            _email = value
         }
      }


   fun addUser() {
      logInfo(tag,"addUser()")
      val user = User(
         name = name,
         email = email
      )
      viewModelScope.launch(_dispatcher) {
         _userRepository.add(user)
      }
   }

   fun updateUser(id: UUID) {
      viewModelScope.launch(_dispatcher) {
         _userRepository.findById(id)?.let { user ->
            logInfo(tag,"updateUser()")
            user.name = name
            user.email = email
            _userRepository.update(user)
         }
      }
   }

   fun deleteUser(id: UUID) {
      viewModelScope.launch(_dispatcher) {
         _userRepository.findById(id)?.let { user ->
            logInfo(tag,"deleteUser()")
            _userRepository.remove(user)
         }
      }
   }

   override fun onCleared() {
      super.onCleared()
      logInfo(tag,"onCleared()")
   }

   companion object {
                    // 12345678901234567890123
      private const val tag = "ok>MainViewModel      ."
   }
}