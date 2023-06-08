import axios from "axios";
import { useEffect, useState } from "react";
import * as Icon from 'react-bootstrap-icons';

function AreaList({onCur_AreaChange}) {
    const [cur_area, setCur_Area] = useState(1);
    const [cur_areaName, setCur_AreaName] = useState("");
    const [area_list, setArea_List] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/api/area/getAll")
        .then((res) => {
            setArea_List(res.data);
        })
        .catch((err) => {
            console.log(err);
        })
    },[])

    useEffect(() => {
        if (area_list.length > 0) {
          setCur_AreaName(area_list[0].areaname);
        }
      }, [area_list]);

    const handleClick = (areaId) => {
        const selectedArea = area_list.find((area_list) => area_list.id === areaId);
        if (selectedArea) {
          onCur_AreaChange(selectedArea.id);
          setCur_Area(selectedArea.id);
          setCur_AreaName(selectedArea.areaname);
        }
    };

    return (
        <div>
            {area_list.map(area_list => (
                <button class = "btn btn-light" key={area_list.id} onClick={() => handleClick(area_list.id)}>
                        {area_list.id}
                </button>
            ))}
            <button class = "btn btn-link">
                <Icon.PlusSquareDotted size={28}></Icon.PlusSquareDotted>
            </button>
            <div class = "d-flex justify-content-center h1">{cur_areaName}</div>
        </div>
    );
}

export default AreaList;