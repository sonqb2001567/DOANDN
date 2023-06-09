import { useEffect, useState } from 'react';
import './App.css';
import AreaList from './component/AreaList';
import LEDButton from './component/LEDButton';
import LineChart from './component/LineChart';
import LoginPage from './component/LoginPage';
import axios from 'axios';
import FanButton from './component/FanButton';
import "./style/App.css";
import * as Icon from 'react-bootstrap-icons';
import DevicesForm from './component/DevicesForm';

function App() {
  const[cur_area, setCur_Area] = useState(1);
  const [devices, setDevices] = useState([]);
  const [plusTrigger, setTrigger] = useState(false);
  
  useEffect(() => {
      axios.get("http://localhost:8080/api/devices/getAreaDevices/" + cur_area)
      .then((res) => {
        setDevices(res.data);
      })
      .catch((err) => {
        console.log(err);
      })

  }, [cur_area])


  return (
    <div className="App">
      <AreaList onCur_AreaChange={setCur_Area}></AreaList>
        {devices.map( devices => (
          <div key={devices.id} class="Chart-holder">
            {
              devices.devicetype === "led" || devices.devicetype === "fan" ? 
              ( 
                devices.devicetype === "led" ? <LEDButton key={devices.id} device_name={devices.devicename} device_feed={devices.feedname} area_id={devices.id} /> 
                : 
                <FanButton key={devices.id} device_name={devices.devicename} device_feed={devices.feedname} area_id={devices.id}/> 
              ) 
              : 
              (<LineChart 
                key={devices.id}
                device_id={devices.id} 
                device_type={devices.devicetype}
                area_id={devices.areaid}
                feed_name={devices.feedname}
                device_name={devices.devicename}/>)
            }
          </div>
        ))}
      <div class="d-flex justify-content-center h-100 p-5">
        <button class="btn btn-outline-primary" onClick={() => setTrigger(true)}>
          <Icon.Plus size={30}></Icon.Plus>
        </button>
      </div>
      <DevicesForm curArea = {cur_area} trigger = {plusTrigger} setPlusTrigger={setTrigger} ></DevicesForm>
    
    </div>
  );
}

export default App;
