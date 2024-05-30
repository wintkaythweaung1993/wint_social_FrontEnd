import { Avatar, Card, CardActions, CardContent, CardHeader, CardMedia, IconButton, Typography } from '@mui/material'
import MoreVertIcon from '@mui/icons-material/MoreVert';
import React from 'react'
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import ShareIcon from '@mui/icons-material/Share';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import BookmarkIcon from '@mui/icons-material/Bookmark';



const PostCard = () => {
  return (
    <Card className=''>
      <CardHeader
       
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title="Find me in the purple"
        subheader="@codewithwint"
      />

        <CardMedia
        component="img"
        height="194"
        image="https://cdn.pixabay.com/photo/2023/09/17/22/25/witch-8259351_1280.jpg"
        alt="Paella dish"
      />

        <CardContent>
        <Typography variant="body2" color="text.secondary">
          This impressive paella is a perfect party dish and a fun meal to cook
          together with your guests. Add 1 cup of frozen peas along with the mussels,
          if you like.
        </Typography>
      </CardContent>

      <CardActions className='flex justify-between' disableSpacing>

        <div>
        <IconButton>
             {true?<FavoriteIcon/>:<FavoriteBorderIcon/>}
        </IconButton>
       

        <IconButton>
             {<ShareIcon/>}
        </IconButton>

        
        <IconButton>
             {<ChatBubbleIcon/>}
        </IconButton>


        </div> 

        <div>
            <IconButton>
            {true?<BookmarkIcon/>:<BookmarkBorderIcon/>}
            </IconButton>
          
        </div>
         
      </CardActions>
     
      
    </Card>
  )
}

export default PostCard
