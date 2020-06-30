import React, { useState, useEffect, useRef } from 'react';
import axios from "axios";


const artistURL = "http://localhost:8080/artists"; 



const ArtistProfiles = () =>{
const [artistProfiles, setArtistProfiles] = useState([]);

    const fetchArtists = () => {
        axios.get(artistURL).then(res =>{
            console.log(res);
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
    //extra [] when our list get updated, function is called again, updating our display to show incoming data.
}




function App() {
    const artistNameRef = useRef() //accessing the values inside the textBox



    async function addingNewArtist(event){
       event.preventDefault()
       let artistName = artistNameRef.current.value
        if (artistName === ' ') return
        // artistName.current = null // clearing the text field after use.
        try {
            const response = await axios.post(artistURL, artistName);
            console.log('Returned data:', response);
          } catch (event) {
            console.log(`Axios request failed: ${event}`);
          }
    }


    return(
        <>
            <ArtistProfiles/>
            <input ref={artistNameRef} type="text" />
            <button onClick={addingNewArtist}>Add Artist</button>
            <button>Delete Artist</button>

            
        </>
    );


}
export default App;