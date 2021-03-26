const headerDiv = document.getElementById("header");

const render = () => {
    
var headerToRender = React.createElement(
    "div",
    { className: "league-bar"},
    React.createElement("button",null,"Premier League "),
    React.createElement("button",null,"La liga"),
    React.createElement("button",null,"Ekstraklasa"),
    React.createElement("button",null,"LM")
);
    ReactDOM.render(headerToRender,headerDiv);
}

setInterval(render);