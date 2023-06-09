import React from 'react'
import { useEffect, useState } from "react";
import '../style/AreaForm.css' ;
import axios from 'axios';

function AreaNameChange({trigger, setTrigger, curAreaId}) {
  const [areaName, setAreaName] = useState("");

  const handleSubmit = () => {
    axios.put("http://localhost:8080/api/area/update/" + curAreaId,
      JSON.stringify({areaname: areaName}),
      {
          headers: {"Content-Type" : "application/Json"},
          withCredentials: true 
      });
      setTrigger(false);
  }

  return (trigger) ? (
    <div>
        <form class="Areaform">
          <div class="bg-light w-50 h-25 position-relative">
            <button class="btn-close position-absolute top-0 end-0" onClick={() => setTrigger(false)} ></button>
            <div class="d-flex justify-content-center align-middle">
              <p class="mt-3">New Area Name:</p>
              </div>
              <div class="d-flex justify-content-center align-middle">
                <input value={areaName} 
                  onChange={(e) => setAreaName(e.target.value)}
                  type="areaName" 
                  placeholder="Area Name" 
                  id="areaName" 
                  name="areaName" 
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

export default AreaNameChange;
