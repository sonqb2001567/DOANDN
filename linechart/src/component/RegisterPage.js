import React from 'react'
import { useState, useEffect } from 'react'
import axios from 'axios';
import { useNavigate } from "react-router-dom";

export default function RegisterPage(props) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [fullname, setFullname] = useState("");
    const navigate = useNavigate();

    const baseURL = "http://localhost:8080/api/v1/user/save";

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const res = await axios.post(baseURL, JSON.stringify({fullname, username, userpassword : password}), 
                {
                    headers: {"Content-Type" : "application/Json"},
                    withCredentials: true 
                });
            console.log(JSON.stringify(res?.data));
            navigate('/login');
        } catch (err) {
        
        }
    }
  return (
    <div>
        <div class="container mt-5">
            
                <h2>Register</h2>
         
            
            <form class="d-flex flex-column"  onSubmit={handleSubmit}>
            <label class="pt-3" htmlFor="fullname">fullname</label>
                <div class="justify-content-center">
                    <input class="w-25 " value={fullname} onChange={(e) => setFullname(e.target.value)}type="fullname" placeholder="your fullname" id="username" name="fullname" />
                </div>
                <label class="pt-3" htmlFor="username">username</label>
                <div class="justify-content-center">
                    <input class="w-25 "  value={username} onChange={(e) => setUsername(e.target.value)}type="username" placeholder="your username" id="username" name="username" />
                </div>
                <label class="pt-3" htmlFor="password">password</label>
                <div class="justify-content-center">
                    <input class="w-25 "  value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" id="password" name="password" />
                </div>
                <div class="justify-content-center pt-5">
                    <button  class="w-25 btn btn-outline-success " type="submit">submit</button>
                </div>
            </form>
        </div>
    </div>
  )
}
