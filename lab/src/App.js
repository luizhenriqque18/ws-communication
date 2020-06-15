import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import { api, apiRoutes } from './Service';
import { wait } from '@testing-library/react';

function App() {

  let [img , setImg] = useState('');

  useEffect(()=>{
    getImg();
  },[])

  async function upload(file){
    //setImg('data:image/png;base64,'+ file.target.files);
    console.log(file.target.files[0]);

    let restData = new FormData();

    restData.append('file', file.target.files[0], file.target.files[0].name)
    
    console.log(restData);

    let {data} = await api.post(apiRoutes.UPLOAD_IMG, restData);
    

    //setImg('data:image/png;base64,'+ file.target.files)
  }

  async function getImg(){
    let {data} = await api.get(`${apiRoutes.GET_IMG}/agora.png`);
    console.log(data);
    setImg('data:image/png;base64,'+ data.picByte)
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={img} className="App-logo" alt="logo" />
        <p>
          GG <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <input type="file" onChange={e => upload(e)} />
    </div>
  );
}

export default App;
