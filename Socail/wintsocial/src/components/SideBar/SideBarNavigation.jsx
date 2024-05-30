import HomeIcon from '@mui/icons-material/Home';
import ExploreIcon from '@mui/icons-material/Explore';
import ControlPointIcon from '@mui/icons-material/ControlPoint';

import MessageIcon from '@mui/icons-material/Message';
import FormatListBulletedIcon from '@mui/icons-material/FormatListBulleted';
import NotificationsIcon from '@mui/icons-material/NotificationsNone';

import AccountCircleIcon from '@mui/icons-material/People';
import GroupIcon from '@mui/icons-material/Group';


export const navigationMenu =[
{
    title:"Home",
    icon:<HomeIcon/>,
    path: "/"

},
{
    title:"Reels",
    
    icon:<ExploreIcon/>,
    path:"/reels"

},
{
    title:"Create Reels",
    icon:<ControlPointIcon/>,
    path:"/create-reels"

},
{
    title:"Notification",
    icon:<NotificationsIcon/>,
    path:"/"

},
{
    title:"Message",
    icon:<MessageIcon/>,
    path:"/message"

},
{
    title:"Lists",
    icon:<FormatListBulletedIcon/>,
    path:"/"

},
{
    title:"Communities",
    icon:<GroupIcon/>,
    path:"/"

},{
    title:"Profile",
    icon:<AccountCircleIcon/>,
    path:"/profile"

}]