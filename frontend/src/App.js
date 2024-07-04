import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import axios from "axios";

function App() {

  const [id, setId] = useState(0)
  const [counter, setCounter] = useState(0)

  useEffect(() => {
    axios.get("http://localhost:8082/counter/" + id).then((res) => {
      setCounter(res.data)
      console.log(res)
    })
  }, [id]);

  function handleClick(){
    axios.post("http://localhost:8082/counter/" + id).then((res) => {
      console.log(res)
      setCounter(res.data)
    })
  }
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo"/>
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
        >
          Learn React
        </a>
        <div>
          Id: <input type={"number"} value={id} onChange={(e) => setId(e.target.value)}/>
        </div>
        <div>
          Counter= {counter} <button onClick={handleClick}>Click</button>
        </div>
      </header>
    </div>
  );
}

export default App;
