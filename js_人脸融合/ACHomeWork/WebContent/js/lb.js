let timer = null;	//定时器（实现自动跳转）
let index = 0;		//索引有五个，分别定位了要显示的五张图（索引从0~4）
//获取轮播片右下角的圆点导航对象
let dots = document.getElementsByTagName("span");	
//事件的触发，表示资源已经加载完成,则执行init初始化操作		
window.addEventListener('load', init, false);	


//初始化能够操作的控件
function init() {
	 //获取到 wrap（因为要设置其left才能控制轮播图）
    var wrap = document.querySelector(".wrap"); 
    var next = document.querySelector(".arrow_right");	//获取到左箭头
    var prev = document.querySelector(".arrow_left");	//获取到右箭头
    // 当鼠标点击左箭头
    next.onclick = function () {					    
        next_pic(wrap);				//往左切图
    }
    prev.onclick = function () {  		// 当鼠标点击左箭头
        prev_pic(wrap);					//往右切图
    }
    autoPlay(wrap);				    //启动定时器自动播放轮播图
    // 取到轮播片容器对象
    var container = document.querySelector(".container");	
    //鼠标停在轮播片时
    container.onmouseenter = function () {					
        clearInterval(timer);		//取消自动播放
    }
  //鼠标离开轮播片时
    container.onmouseleave = function () {				
        autoPlay(wrap);		//自动播放
    }
}


//用户的上一页操作（图片向右移动）
function prev_pic(wrap) {	
    index--;			//索引定位到上一页
    if (index < 0) {	//退到第一页再往前翻，则打开图片索引为4的图
        index = 4;
    }
    showCurrentDot(wrap);	//显示当前图片
    var newLeft;
     //首页是从left=-700开始的，往前翻一页则为0（图片宽700）
    //往后则是-1400，所以往后四页的临界值为-2800，以此类推
   //如果从第一页(实际显示5.jpg)往前翻，则回到第五页（实际显示4.jpg）的left值
  //不恒等，判断数值和类型是否完全一致
    if (wrap.style.left === "0px") {	
    	//left的临界值，container中显示大于这个值则会出现空白
        newLeft = -2800;		
    } else {	//如果是其他页往前翻，则正常定位图片位置。
        newLeft = parseInt(wrap.style.left) + 700;
    }
    wrap.style.left = newLeft + "px";		//加上单位
}


//用户的下一页操作（图片往左移动）
function next_pic(wrap) {		
    index++;				//索引定位到下一页
    if (index > 4) {		//如果在最后一页往后一页。
        index = 0;			//则索引定位回第一页
    }
    showCurrentDot(wrap);	//显示当前图片    var newLeft;
  //如果正在显示的是最后一页图片
    if (wrap.style.left === "-4200px") {
    	//则回到第二页（因为第一页和最后一页图片一样的）
        newLeft = -1400;			
    } else {		//否则正常向左定位图片开始的位置
        newLeft = parseInt(wrap.style.left) - 700;
    }
    wrap.style.left = newLeft + "px";	//加单位
}


//定时器 ，实现自动播放
function autoPlay(wrap) {	
    timer = setInterval(function () {	//表示隔两秒，往下翻图
        next_pic(wrap);
    }, 2000);
}


//显示当前是第几张图片
function showCurrentDot(wrap) {		
    for (var i = 0, len = dots.length; i < len; i++) {
        dots[i].className = "";		//小圆点空心显示。
    }
    dots[index].className = "on";	//正显示图片对应的小圆点变为实心。
}

//圆点导航代码，点击圆点切换到不同的图片，圆点导航的圆点定位原理和轮播图类似。
for (var i = 0, len = dots.length; i < len; i++) {
    (function (i) {
    	//利用选择器找到css中的wrap,即小圆点
        let wrap = document.querySelector(".wrap");
        //设置每个小圆点的点击监听事件
        dots[i].onclick = function () {
        	//获取到显示小圆点的索引值
            var dis = index - i;
            //圆点原理和轮播图一致，获取到相对镜头的left值即可
            //如果显示小圆点处于最后一个，向后操作
            if (index == 4 && parseInt(wrap.style.left) !== -3500) {
                dis = dis - 5;	//则返回到第一个小圆点的索引（代表最后一张图）
            }
            //如果显示小圆点处于第一个，向前操作
            if (index == 0 && parseInt(wrap.style.left) !== -700) {
                dis = 5 + dis;	//则直接跳到最后一个小圆点索引（代表最后一张图）
            }
            //设置显示小圆点的新left值
            wrap.style.left = (parseInt(wrap.style.left) + dis * 700) + "px";
            index = i;	//获取显示小圆点当前的位置
            showCurrentDot(wrap);	//将显示小圆点变成实心显示
        }
    })(i);
}