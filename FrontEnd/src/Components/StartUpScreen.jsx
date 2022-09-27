import React from "react";
import '../startUpStyle.css'


const StartUp = () => {
    const handleEasyClick = () =>{
        console.log("easy selected")
    }
    const handleMediumClick = () =>{
        console.log("medium selected")
    }
    const handleHardClick = () =>{
        console.log("hard selected")
    }
    const handleSmallClick = () =>{
        console.log("small selected")
    }
    const handleRegularClick = () =>{
        console.log("reular selected")
    }
    const handleLargeClick = () =>{
        console.log("hard selected")
    }
    const handleSubmitClick = () =>{
        console.log("Submit selected")
    }
    return (
        <div>
            <div className="main">
                <div className="Difficulty">
                    <h1>Difficulty</h1>
                    <input type="radio" name="Difficulty" value="Easy" onChange={handleEasyClick}/>Easy
                    <input type="radio" name="Difficulty" value="Medium" onChange={handleMediumClick}/>Medium
                    <input type="radio" name="Difficulty" value="Hard" onChange={handleHardClick}/>Hard
                </div>
                <div className="Size">
                    <h1>Size</h1>
                    <input type="radio" name="Size" value="Small" onChange={handleSmallClick}/>Small
                    <input type="radio" name="Size" value="Regular" onChange={handleRegularClick}/>Regular
                    <input type="radio" name="Size" value="Large" onChange={handleLargeClick}/>Large                       
                </div>
                <div className="Submit"><button type="button" id="submitBTN" onClick={handleSubmitClick}>Submit</button></div>
            </div>
        </div>
    )

}
export default StartUp;