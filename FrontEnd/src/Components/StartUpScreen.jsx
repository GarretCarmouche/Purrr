import React from "react";

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
    return (
        <div className="startUp">
            <button onClick={handleEasyClick}>Easy</button>     
            <button onClick={handleMediumClick}>Medium</button>                        
            <button onClick={handleHardClick}>Hard</button>                        
            <button onClick={handleSmallClick}>Small</button>                        
            <button onClick={handleRegularClick}>Regular</button>                        
            <button onClick={handleLargeClick}>Large</button>                        
        </div>
    )

}
export default StartUp;