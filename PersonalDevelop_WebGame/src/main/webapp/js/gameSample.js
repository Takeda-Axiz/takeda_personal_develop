
/**
 * runstant
 */

//グローバルに展開
phina.globalize();

//定数
var ASSETS = {
		image: {
			map: "img/BlackBlock.png",
			parts01: "img/BlackBlock_parts01.png",
			parts02: "img/BlackBlock_parts02.png",
			playerIcon: 'img/PlayerBlock.png',
		},
};
var SCREEN_WIDTH  = 2800;              // スクリーン幅
var SCREEN_HEIGHT = 700;              // スクリーン高さ
var SPEED         = 4;

var OBJECT_POSX = [
	50, 150, 250, 350, 450, 550, 650, 750, 850, 950, 1050, 1150, 1250, 1350, 1450, 1550, 1650, 1750, 1850, 1950, 2050, 2150, 2250, 2350, 2450, 2550, 2650, 2750,
	50,                          650,                1050,                                           1850,                         2445, 2450, 2550, 2650, 2750,
	50,                          650,      850,      1050,       1250, 1350, 1450,       1671,       1850,       2050, 2150, 2250, 2445, 2450, 2550, 2650, 2750,
	50,                                    850,      1050,             1350,             1671,                   2050, 2150, 2250, 2445, 2453,
	50,                          650,      850,      1050, 1150,       1350,       1570, 1650, 1750, 1850,       2050, 2150, 2250, 2445, 2453, 2647, 2650, 2750,
	50,                          650, 750, 850,                        1350, 1360,                               2050, 2150, 2250,             2647, 2650, 2750,
	50, 150, 250, 350, 450, 550, 650, 750, 850, 950, 1050, 1150, 1250, 1350, 1450, 1550, 1650, 1750, 1850, 1950, 2050, 2150, 2250, 2350, 2450, 2550, 2650, 2750
	];

var OBJECT_POSY = [
	50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,  50,
	150,                          150,                150,                                    150,                     150, 150, 150, 150, 150,
	250,                          250,      250,      250,      250, 250, 250,      250,      250,      250, 250, 250, 250, 250, 250, 250, 250,
	350,                                    350,      350,           350,           350,                350, 350, 350, 350, 350,
	450,                          450,      450,      450, 450,      450,      450, 450, 450, 450,      450, 450, 450, 450, 450, 450, 450, 450,
	550,                          550, 550, 550,                     550, 550,                          550, 550, 550,           550, 550, 550,
	650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650
	];

var isClick = false;

//var IMAGE_WIDTH = 2800;
//var gridX = Grid(SCREEN_WIDTH, 8);

/**
 * メインシーン
 */
phina.define("MainScene", {
	// 継承
	superClass: 'CanvasScene',

	// 初期化
	init: function(options) {
		// super init
		this.superInit(options);

		var i = 0;
		// 障害物
		this.shapeGroup = CanvasElement().addChildTo(this);
		// n 回繰り返す
		(122).times(function() {
			// スターを生成
			var star = Sprite("map").addChildTo(this.shapeGroup);
			// 位置をランダムに設定
			star.x = OBJECT_POSX[i];
			star.y = OBJECT_POSY[i];
			i++;
		}, this);

		// スターを生成
		var star = Sprite("parts01").addChildTo(this.shapeGroup);
		// 位置をランダムに設定
		star.x = 1415;
		star.y = 575;

		// スターを生成
		var star = Sprite("parts01").addChildTo(this.shapeGroup);
		// 位置をランダムに設定
		star.x = 1516;
		star.y = 425;

//		// スターを生成
//		var star = Sprite("parts02").addChildTo(this.shapeGroup);
//		// 位置をランダムに設定
//		star.x = 2602;
//		star.y = 305;

//		// スターを生成
//		var star = Sprite("parts02").addChildTo(this.shapeGroup);
//		// 位置をランダムに設定
//		star.x = 2602;
//		star.y = 395;

		// プレイヤー
		this.player = Sprite('playerIcon', 80, 80).addChildTo(this);
		this.player.setPosition(SCREEN_HEIGHT / 2, this.gridY.center());
		this.player.frameIndex = 0;
	},

	// 更新
	update: function(app) {
		var p = app.pointer;

		this.one('pointend', function() {
			if(app.pointer.x >= 0 && app.pointer.x <= SCREEN_HEIGHT) {
				this.player.x = SCREEN_HEIGHT / 2;
				this.player.y = this.gridY.center();
				isClick = true;
			}
		});

		if(isClick == true) {
			this.player.x = app.pointer.x;
			this.player.y = app.pointer.y;
		}

//		if (p.getPointing()) {
//		// 左右移動
//		var diffx = this.player.x - p.x;
//		if (Math.abs(diffx) > SPEED) {
//		// 右に移動
//		if (diffx < 0) {
//		this.player.x += SPEED;
//		this.player.scaleX = -1;
//		}
//		// 左に移動
//		else {
//		this.player.x -= SPEED;
//		this.player.scaleX = 1;
//		}



//		// フレームアニメーション
//		if (app.frame % 4 === 0) {
//		this.player.frameIndex = (this.player.frameIndex === 12) ? 13:12;
//		}
//		}

//		// 上下移動
//		var diffy = this.player.y - p.y;
//		if (Math.abs(diffy) > SPEED) {
//		// 下に移動
//		if (diffy < 0) {
//		this.player.y += SPEED;
//		this.player.scaleY = -1;
//		}
//		// 上に移動
//		else {
//		this.player.y -= SPEED;
//		this.player.scaleY = 1;
//		}

//		// フレームアニメーション
//		if (app.frame % 4 === 0) {
//		this.player.frameIndex = (this.player.frameIndex === 12) ? 13:12;
//		}
//		}
//		}
//		else {
//		// 待機
//		this.player.frameIndex = 0;
//		}

		this.shapeGroup.children.each(function(child) {
			// プレイヤーとシェープの衝突判定
			if (this.player.hitTestElement(child)) {
				// 衝突していたら色を変える
				window.location.href = 'gameOver';
			}
		}, this);

		if(this.player.x >= SCREEN_WIDTH - 40){
			window.location.href = 'gameResult';
		}
	}
});

/**
 * メイン処理
 */
phina.main(function() {
	// アプリケーションを生成
	var app = GameApp({
		startLabel: 'main',   // MainScene から開始
		width: SCREEN_WIDTH,  // 画面幅
		height: SCREEN_HEIGHT,// 画面高さ
		assets: ASSETS,       // アセット読み込み
	});

//	app.enableStats();

	// 実行
	app.run();


});
