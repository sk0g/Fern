package com.ymir.fern_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.ymir.fern_app.ActivitySwitcher.switchToProfile

class CreateProfileActivity : AppCompatActivity() {

    private lateinit var mFirstName: EditText
    private lateinit var mLastName: EditText
    private lateinit var mUniversity: EditText
    private lateinit var mCampus: EditText
    private lateinit var mDegree: EditText
    private lateinit var mBio: EditText
    private lateinit var mSubmitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)

        var person:Person = Person.getInstance()

        mFirstName = findViewById(R.id.create_profile_first_name)
        if (person.firstName != null) { mFirstName.setText(person.firstName) }

        mLastName = findViewById(R.id.create_profile_last_name)
        if (person.secondName != null) { mLastName.setText(person.secondName) }

        mUniversity = findViewById(R.id.create_profile_university)
        if (person.university != null) { mUniversity.setText(person.university) }

        mCampus = findViewById(R.id.create_profile_campus)
        if (person.campus != null) { mCampus.setText(person.campus) }

        mDegree = findViewById(R.id.create_profile_degree)
        if (person.degree != null) { mDegree.setText(person.degree) }

        mBio = findViewById(R.id.create_profile_bio)
        if (person.bio != null) { mBio.setText(person.bio) }


        mSubmitButton = findViewById(R.id.create_profile_submit_button)
        mSubmitButton.setOnClickListener { view ->
            submitData()
            switchToProfile(applicationContext, view)
        }
    }

    fun submitData() {
        val person: Person = Person.getInstance()

        person.firstName = mFirstName.text.toString()
        person.secondName = mLastName.text.toString()
        person.university = mUniversity.text.toString()
        person.campus = mCampus.text.toString()
        person.degree = mDegree.text.toString()
        person.bio = mBio.text.toString()
    }
}
