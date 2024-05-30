import { Avatar } from '@mui/material'
import React from 'react'

const StoryCircle = () => {
  return (
    <div>
      <div className="flex flex-col items-center mr-4 cursor-pointer ">
            <Avatar sx ={{width : "5rem" , height : "5rem"}}
             src="https://cdn.pixabay.com/photo/2021/04/05/04/21/ao-dai-6152101_1280.jpg"
            >
            
            </Avatar>
          
          <p>Codewithwint....</p>

          </div>
    </div>
  )
}

export default StoryCircle
