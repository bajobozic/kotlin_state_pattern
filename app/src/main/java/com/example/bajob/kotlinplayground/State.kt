package com.example.bajob.kotlinplayground

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

/**
 * Created by bajob on 2/19/2018.
 */
sealed class State : StateTransitions {
    override fun goToIdState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToCardState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToManualState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToInitState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class InitialState(override val context: Context) : State() {
    override fun goToIdState() {
        val c = context as StateClient
        c.currentState = IdScaningState(c)
        val intent = Intent(c, IdScaningActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        c.startActivityForResult(intent, 234)
    }

}

class IdScaningState(override val context: Context) : State() {

    override fun goToIdState() {
        val c = context as StateClient
        c.currentState = CardScanningState(c)
        val intent = Intent(c, CardScaningActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        c.startActivityForResult(intent, 567)
    }

    override fun goToCardState() {

    }

    override fun goToManualState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToInitState() {
        val c = context as StateClient
        c.currentState = InitialState(c)
    }

}

class CardScanningState(override val context: Context) : State() {

    override fun goToIdState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToCardState() {
        val c = context as StateClient
        c.currentState = EnterCredentialsState(c)
        val intent = Intent(c, ManualActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        c.startActivityForResult(intent, 890)
    }

    override fun goToManualState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToInitState() {
        val c = context as StateClient
        c.currentState = InitialState(c)
    }

}

class EnterCredentialsState(override val context: Context) : State() {
    override fun goToIdState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToCardState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToManualState() {
        val c = context as StateClient
        print("Entering user credentials")
        print("User credentials entered")
        if (c.validateFormState()) {
            c.setResult(1)
            c.finish()
        } else {
            c.currentState.goToInitState()
        }
    }

    override fun goToInitState() {
        val c = context as StateClient
        c.currentState = InitialState(c)
    }

}

interface StateTransitions {
    val context: Context

    fun goToInitState()
    fun goToIdState()
    fun goToCardState()
    fun goToManualState()
}

class StateClient : AppCompatActivity() {
    lateinit var currentState: State

    val button: Button by lazy { Button(baseContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentState = InitialState(this)
        button.setOnClickListener { currentState.goToIdState() }
    }

    fun validateFormState(): Boolean {
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                234 -> currentState.goToCardState()
                567 -> currentState.goToManualState()
                890 -> currentState.goToInitState()
            }
        } else {
            currentState.goToInitState()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}

class IdScaningActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}

class CardScaningActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}

class ManualActivity : AppCompatActivity() {
    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}


