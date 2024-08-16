import React from 'react'
import './CSS/LoginSignup.css';

export default function LoginSignup() {
  return (
    <div className='LoginSignup'>
      <div className="LoginSignup-container">
        <h1>Sing Up</h1>
        <div className="loginsingup-fields">
          <input type="text" placeholder='Your Name' />
          <input type="email" placeholder='Email Address' />
          <input type="password" placeholder='Password' />
        </div>
        <button>Continue</button>
        <p className='loginsignup-login'>Already have an account? <span>Login here</span></p>
        <div className="loginsignup-agree">
          <input type="checkbox" name='' id='' />
          <p>By continuing,i agree to the terms of use & privacy policy</p>
        </div>
      </div>
    </div>
  )
}
