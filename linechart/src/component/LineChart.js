import {Line} from 'react-chartjs-2';
import { 
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement
} from 'chart.js';
import React from 'react';
import { useState, useEffect } from 'react';
import axios from 'axios';
import "../style/LineChart.css";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement
)
const tempURL="http://localhost:8080/api/temp/getAreaTemp/";
const moisURL="http://localhost:8080/api/mois/getAreaMois/";

function LineChart({device_id, device_type, area_id, feed_name, device_name}) {
    const [cur_area, setCur_Area] = useState(area_id);
    const [temp, setTemp] = useState([]);
    const [feed, setFeed] = useState("");
    const [chartType, setChartType] = useState(null);
    const [deviceID, setDeviceID] = useState(device_id);
    const [baseReqURL, setBaseURL] = useState("");
    
    useEffect(() => {
      if (device_type) { 
        setChartType(device_type);
      }

      if (feed_name) {
        setFeed(feed_name);
      }

      if (chartType === "cbn"){
        setBaseURL(tempURL);  
      }
    
      if (chartType === "cbda"){
        setBaseURL(moisURL);
      }
      
      const fetchData = () => {
        if (feed != null) {
          axios.get("http://localhost:8080/api/feed/" + feed + "/" + area_id);
        }
        
          axios.get(baseReqURL+cur_area)
        .then((res) => {
          setTemp(res.data);
        })
        .catch((err) => {
          console.log(err);
        })
      }
      
      fetchData();

      const intervalId = setInterval(fetchData, 5000);

    return () => {
      clearInterval(intervalId);
    }

  }, [chartType, baseReqURL, cur_area]);

        const data = {
            labels: ["30s", "25s", "20s", "15s", "10s", "5s", "0s"],
            datasets: [{
              data: [null],
              backgroundColor: 'transparent',
              borderColor: '#f26c6d',
              pointBordercolor: 'transparent',
              pointBorderWidth: 4
            }]
        }
        
        const options = {
            plugins: {
              legend: false
            },
            scales: {
              x: {
                grid: {
                  display: false
                }
              },
              y: {
                
              }
            }
          }
    
  if (chartType === "cbn"){
    data.datasets[0].data = temp.map(({temp}) => temp)
  }

  if (chartType === "cbda"){
    data.datasets[0].data = temp.map(({mois}) => mois)
  }
  
  data.datasets[0].data = data.datasets[0].data.reverse();
  
        return(
          <div class="Chart">
            <h1>{device_name}  {chartType === "cbn" ? " | Temperature" : " | Moisture"}</h1>
            <div className="LineChart">
                <Line data = {data} options={options}></Line>
            </div>
          </div>
        ) 
}

export default LineChart;