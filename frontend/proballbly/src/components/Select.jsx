import React, {useState, useEffect} from "react";
import { useHistory, useParams } from "react-router";
import { NavLink } from "react-router-dom";
import "./Select.css"


const Select = (data) => {
    useEffect(() => console.log(data),[]);

    return(
    <div className="selectors">
        <select class="minimal">
            {data.data.table.map((standings) => {
                <option>{standings.position}, {standings.team.name} key={standings.id}</option>
            })}
        </select>
        <select class="minimal">
            {data.data.table.map((standings) => {
                <option>{standings.position}, {standings.team.name} key={standings.id}</option>
            })}
        </select>
    </div>
    );

}
export default Select;