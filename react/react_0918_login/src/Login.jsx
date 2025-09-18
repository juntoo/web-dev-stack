import React, { useState } from "react";
import MainPage from "./MainPage";
import LoginForm from "./LoginForm";

const User = { 
    email:'test@a.com',
    pw:'1111'
}

export default function Login() {

    const [ email, setEmail ] = useState('')
    const [isLogin, setLogin] = useState(false)

    const clickConfirm = (email, pw) => {
    if(User.email === email && User.pw === pw) {
        alert("로그인 성공")
        setEmail(email)
        setLogin(true)
    }else {
        alert("로그인 실패")
    }
}

    return (

        <div>
            { isLogin ? ( <MainPage email={email}/> ) : <LoginForm clickConfirm={clickConfirm} /> }
        </div>
        
    )
}