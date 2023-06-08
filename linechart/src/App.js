import { useEffect, useState } from 'react';
import './App.css';
import AreaList from './component/AreaList';
import LEDButton from './component/LEDButton';
import LineChart from './component/LineChart';
import LoginPage from './component/LoginPage';
import axios from 'axios';
import FanButton from './component/FanButton';


function App() {
  const[cur_area, setCur_Area] = useState(1);
  const [devices, setDevices] = useState([]);
  
  useEffect(() => {
   
      axios.get("http://localhost:8080/api/devices/getAreaDevices/" + cur_area)
      .then((res) => {
        setDevices(res.data);
      })
      .catch((err) => {
        console.log(err);
      })

  }, [cur_area])

  useEffect(() => {
    console.log(devices);
  }, [devices])

  const handleCur_AreaChange = (newArea) => {
    setCur_Area(newArea);
  };

  return (
    <div className="App">
      <AreaList onCur_AreaChange={handleCur_AreaChange}></AreaList>

      
        {devices.map( devices => (
          <div key={devices.id}>
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
    </div>
  );
}

export default App;
