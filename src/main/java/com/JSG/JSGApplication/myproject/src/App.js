import React, { useState, useEffect } from 'react';
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";



const ArtistProfiles = () =>{
const [artistProfiles, setArtistProfiles] = useState([]);

    const fetchArtists = () => {
        axios.get("http://localhost:8080/artists").then(res =>{
            console. log(res);
            setArtistProfiles(res.data)
        });
    }

    useEffect(() => {
        fetchArtists();
    }, []);


    return artistProfiles.map((artistProfile, index) =>{
        return(
            <div key={index}>
                Name: {artistProfile.name}

            </div>


        )
    })

    return <h1>Hello</h1>
    //extra [] when our list get updated, function is called again, updating our display to show incoming data.
}




function App() {
    return(
        <div className ="App">
            <ArtistProfiles/>
        </div>
    );


}
export default App;