import React from 'react'
import { navigationMenu } from './SideBarNavigation'
import MoreVertIcon from '@mui/icons-material/MoreVert';
import { Avatar, Button, Divider, Menu, MenuItem } from '@mui/material';
import { useSelector } from 'react-redux';
import { Store } from '@mui/icons-material';
import { Navigate, useNavigate } from 'react-router';

const SideBar = () => {
  const{auth} = useSelector(Store=>Store);
  const navigate=useNavigate();
  const [anchorEl, setAnchorEl] = React.useState(null)
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };


const handleNavigate = (item) => {
  if(item.title ==="Profile")
    {
      navigate(`/profile/${auth.user?.id}`)
    }
}
  return (
    <div className='card h-screen flex flex-col justify-between py-5'>
        <div className=' space-y-8 pl-5'>
            <div className=''>
                <span className='logo font-bold text-xl'>
                    W!nt Soc!al Logo
                </span>

            </div>
            <div className='space-y-8'>
              {navigationMenu.map((item,index)=> (
              <div key = {index} onClick={()=>handleNavigate(item )}className='cursor-point flex space-x-3 items-center'>
                {item.icon}
                <p className='text-xl'>{item.title}</p>
              </div>
            ))}

            </div>

        </div>
            <div>
              <Divider/>
              <div className="pl-5 flex items-center justify-between pt-5">
                <div className="flex items-center space-x-3">
                <Avatar src = "https://cdn.pixabay.com/photo/2023/12/07/19/45/tiger-8436227_1280.jpg"/>
                <div>
                  <p className="font-bold">{auth.user?.firstName + " " + auth.user?.lastName} </p>
                  <p className="opacity-70">@{auth.user?.firstName.toLowerCase() + "_" + auth.user?.lastName.toLowerCase()}</p>
                </div>
              </div>

              <Button
        id="basic-button"
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={handleClick}
      >
       <MoreVertIcon/>
      </Button>
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
        MenuListProps={{
          'aria-labelledby': 'basic-button',
        }}
      >
        <MenuItem onClick={handleClose}>Profile</MenuItem>
        <MenuItem onClick={handleClose}>My account</MenuItem>
        <MenuItem onClick={handleClose}>Logout</MenuItem>
      </Menu>
              </div>
            </div>
      
    </div>
  );
}

export default SideBar
