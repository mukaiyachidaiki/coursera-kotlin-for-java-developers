package info.mukaiyachi.coursera_kotlin_for_java_developers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("test", "結果1 => " + isValidIdentifier("name"))   // true
        Log.d("test", "結果2 => " + isValidIdentifier("_name"))  // true
        Log.d("test", "結果3 => " + isValidIdentifier("_12"))    // true
        Log.d("test", "結果4 => " + isValidIdentifier(""))       // false
        Log.d("test", "結果5 => " + isValidIdentifier("012"))    // false
        Log.d("test", "結果6 => " + isValidIdentifier("no$"))    // false
    }

    private fun isValidIdentifier(s: String) : Boolean {
        // 模範解答
        fun isValidCharacter(ch: Char) = ch == '_'
                || ch.isLetterOrDigit()
                //|| ch in '0' .. '9' || ch in 'a' .. 'z' || ch in 'A' .. 'Z'

        if (s.isEmpty() || s[0].isDigit()) return false
        //if (s.isEmpty() || s[0] in '0' .. '9') return false

        for (ch in s) {
            if (! isValidCharacter(ch)) return false
        }

        return true

        /*
        // 向谷地
        return if (s in "a".."z" || s in "A".."Z" || s == "_" || s.firstOrNull().toString() == "_") {
            !s.contains("$")
        } else {
            false
        }
         */
    }
}
