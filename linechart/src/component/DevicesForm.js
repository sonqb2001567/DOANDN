import React from 'react'
import { useEffect, useState } from "react";
import axios from 'axios';
import "../style/DevicesForm.css";

function DevicesForm({curArea, trigger, setPlusTrigger}) {
  const [feed_name, setFeedName] = useState("");
  const [device_type, setDeviceType] = useState("")
  const [device_name, setDeviceName] = useState("");


  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = 
        await axios.post("http://localhost:8080/api/devices/save", 
            JSON.stringify({
                devicename : device_name,
                areaid : curArea,
                devicetype : device_type,
                feedname : feed_name
            }), 
          {
              headers: {"Content-Type" : "application/json"},
              withCredentials: true 
          });
      console.log(JSON.stringify(res?.data));
      setPlusTrigger(false)
    } catch (err) {
        console.log(err);
    }    
  }

  return (trigger) ? (
    <div>
        <form class="Deviceform">
          <div class="bg-light w-25 h-50 position-relative">
            <button class="btn-close position-absolute top-0 end-0" onClick={() => setPlusTrigger(false)} ></button>
            <div class="d-flex justify-content-center align-middle">
              <p class="mt-3">Device Name:</p>
            </div>
                <div class="d-flex justify-content-center align-middle">
                    <input value={device_name} 
                        onChange={(e) => setDeviceName(e.target.value)}
                        placeholder="Device Name" 
                        class=""
                    />
                </div>
            
            <div class="d-flex justify-content-center align-middle">
              <p class="mt-3">Device Type:</p>
            </div>
                <div class="d-flex justify-content-center align-middle">
                    <input value={device_type} 
                        onChange={(e) => setDeviceType(e.target.value)}
                        placeholder="Device Type" 
                        class=""
                    />
                </div>

            <div class="d-flex justify-content-center align-middle">
              <p class="mt-3">Feed Name:</p>
            </div>
                <div class="d-flex justify-content-center align-middle">
                    <input value={feed_name} 
                        onChange={(e) => setFeedName(e.target.value)}
                        placeholder="Feed Name" 
                        class=""
                    />
                </div>
                
            <div class="d-flex justify-content-center align-middle">
                <button class="btn btn-success mt-3" onClick={handleSubmit}>Create</button>
            </div>

          </div>
        </form>
    </div>
  ) : "";
}

export default DevicesForm;
