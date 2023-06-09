import axios from "axios";
import { useEffect, useState } from "react";
import * as Icon from 'react-bootstrap-icons';
import AreaForm from "./AreaForm";
import "../style/AreaList.css";
import AreaNameChange from "./AreaNameChange";

function AreaList({onCur_AreaChange}) {
    const [cur_area, setCur_Area] = useState(1);
    const [cur_areaName, setCur_AreaName] = useState("");
    const [area_list, setArea_List] = useState([]);
    const [add_click, setAdd_Click] = useState(false);
    const [count, setCount] = useState(0);
    const [trigger, setTrigger] = useState(false);

    useEffect(() => {
        console.log(count);
        axios.get("http://localhost:8080/api/area/getAll")
        .then((res) => {
            setArea_List(res.data);
        })
        .catch((err) => {
            console.log(err);
        })
    },[add_click])  

    useEffect(() => {
        if (area_list.length > 0) {
            setCur_AreaName(area_list[count].areaname);
            onCur_AreaChange(area_list[count].id);
        }
    }, [area_list, count]);

    
    const handleRightArrowClick = () => {
        if (area_list.length > 0) {
            if (count >= area_list.length - 1) {
                setCount(0);
            }
            else {
                setCount(count + 1);
            }

            setCur_Area(area_list[count].id);
        }
    }

    const handleLeftArrowClick = () => {
        if (area_list.length > 0) {
            if (count <= 0) {
                setCount(area_list.length-1);
            }
            else {
                setCount(count - 1);
            }

            setCur_Area(area_list[count].id);
        }
    }

    const handleDeleteClick = () => {
        axios.delete("http://localhost:8080/api/area/delete/"+area_list[count].id);
    }

    return (
        <div class="bg-light fixed-top  " style={{height : "100px"}}>
        <div class="d-flex justify-content-center fixed-top pt-3">
            <button class="btn btn-light pl-3" onClick={() => handleLeftArrowClick()}>
                <Icon.ArrowLeft size={30}></Icon.ArrowLeft>
            </button>
            
            <div class="bg-white w-25">       
            <div class = "d-flex justify-content-center h1">{cur_areaName}</div>
            </div>    

            <button class="btn btn-light" onClick={() => handleRightArrowClick()}>
                <Icon.ArrowRight size={30}></Icon.ArrowRight>
            </button>

            <AreaForm trigger={add_click} setTrigger = {setAdd_Click}></AreaForm>
            <AreaNameChange 
                trigger={trigger} 
                setTrigger={setTrigger} 
                curAreaId={area_list[count]?.id}
            >
            </AreaNameChange>
            <li class="d-flex flex-column position-absolute top-0 end-0 h-75">
                <button class = "btn btn-link p-0" style={{fontSize : "1rem"}} onClick={() => setAdd_Click(true)}>
                    Add Area
                </button>
                <button class = "btn btn-link p-0" style={{fontSize : "1rem"}} onClick={handleDeleteClick}>
                    Delete Area
                </button>
                <button class = "btn btn-link p-0" style={{fontSize : "1rem"}} onClick={() => setTrigger(true)} >
                    Change Area Name
                </button>
            </li>
        </div>
        </div>
    );
}

export default AreaList;