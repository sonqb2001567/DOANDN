import axios from "axios";
import { useEffect, useState } from "react";

function FanButton({device_name, device_feed, area_id}) {
    const [value, setValue] = useState(0);

    const clickLED = () => {
        if (value === 0) {
            setValue(1);
        }
        else {
            setValue(0);
        }

        axios.post("http://localhost:8080/api/addtofeed/" + device_feed + "/" + value)
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            console.error(error);
        });

        console.log("t");
    }

    return(<button class="btn btn-primary" onClick={clickLED}>{device_name}</button>);
}

export default FanButton;