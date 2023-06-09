import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginPage(props) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const baseURL = "http://localhost:8080/api/v1/user/login";

    const navigateToHome = () => {
        navigate('/home');
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(username, password);
        try {
            const res = await axios.post(baseURL, JSON.stringify({username, userpassword: password}), 
                {
                    headers: {"Content-Type" : "application/Json"},
                    withCredentials: true,

                });
            console.log(JSON.stringify(res?.data.status));
            if (res?.data.status) {
                navigateToHome();
            }
        } catch (err) {
        
        }
    }

    return(
        <div class="container mt-5 auth-form-container " >
            <h2>Login</h2>
            <form class="d-flex flex-column " className="login-form" onSubmit={handleSubmit}>
                <label class="pt-3" htmlFor="username">username:</label>
                <div class="justify-content-center">
                    <input class="w-25" value={username} onChange={(e) => setUsername(e.target.value)}type="username" placeholder="your username" id="username" name="email" />
                </div>
                <label class="pt-3" htmlFor="password">password:</label>
                <div class="justify-content-center">
                    <input class="w-25" value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
                </div>
                <div class="justify-content-center pt-3">
                    <button  class="btn btn-success w-25" type="submit">Log In</button>
                </div>
                <div>
                    <p> 
                        <a class="link-underline-info" href="/register">don't have an account?</a>
                    </p>
                </div>
            </form>
        </div>
    )
}

export default LoginPage;