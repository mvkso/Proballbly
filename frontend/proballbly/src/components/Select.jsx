import React, {useState, useEffect} from "react";
import "./css/Select.css"


const Select = (data) => {

    let competitions = data.data[0];
    const [team1, setTeam1] = useState(1);
    const [team2, setTeam2] = useState(1);
    const [result, setResult] = useState("Choose teams and then press calculate button");

    useEffect(() => console.log(competitions));

    function algorithm(){
        let team1points =  parseInt(competitions.table[team1-1].points);
        let team1position = parseInt(competitions.table[team1-1].position);
        let team2points =  parseInt(competitions.table[team2-1].points);
        let team2position = parseInt(competitions.table[team2-1].position);
        let team1result = team1points/team1position;
        let team2result = team2points/team2position;
        let allpoints = team1result+team2result;
        if(team1result>team2result){
            setResult(competitions.table[team1-1].team.name+" is going to win in "+ team1result/allpoints*100+ "%");
        }else if(team1result<team2result){
            setResult(competitions.table[team2-1].team.name+" is going to win in "+ team2result/allpoints*100+ "%");
        }else{
            setResult("There will be draw no cap");
        }
        
             
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        algorithm();

    }

    function handlechange1(e){
        setTeam1(e.target.value);
        setResult("press calculate button");
    }

    function handlechange2(event){
        setTeam2(event.target.value);
        
        setResult("press calculate button");
    }

    return(
    <div className="selectors">
        <header>Calculate probability</header>
        <form onSubmit={handleSubmit}>
            <div className="selects">
            {data.data.map((standings) => {
                return standings.type === "TOTAL"?
                <select className="minimal" id="1" value={team1} onChange={handlechange1}>
                    {standings.table.map((e) => {
                        return(
                            <option key={e.position} value={e.position}>{e.position}. {e.team.name}</option> 
                        );
                    })}
                
                </select>
                :null;
            })}
        
        {data.data.map((standings2) => {
                return standings2.type === "TOTAL"?
                <select className="minimal" id="2" value={team2} onChange={handlechange2}>
                    {standings2.table.map((e2) => {
                        return(
                            <option key={e2.position} value={e2.position}>{e2.position}. {e2.team.name}</option> 
                        );
                    })}
                
                </select>
                :null;
            })}
            
            </div>
           
            <input className="submitInput" type="submit" value="Calculate"  />
            </form>
            <div className="algorithm">{result}</div>
    </div>
    );

}
export default Select;