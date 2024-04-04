import { config } from './config.js';
import { messages } from './messages.js';

// TODO für die nächste Zeit - Module in kleine Klassen auslagern, sodass diese dann gecalled werden und man nicht doppelten code hat
// Coins dynamisch auf der map verteilen (opt checken, ob struktur existiert)
// Handy buttons einbauen, die man angreifen kann
// Colliderhandling verbessern, sodass man keine tilesprite numbers macht

// global vars
let lastfire = 0;
let counter = 0;
let mutevalue = 0;
let fails = 0;
let jumps = 0;
let score = 0;

// background
let clouds, green, darkgreen;
// other stuff
let mario, camera, cursors, jumpkey, jumpkey2, keyboardA, keyboardD;
let map, platform, coins;
let level, flag;
let scoreText, failsCounter, jumpsCounter;
// music
let music, stageclear, death, coinsound, jumpsound;

let jumpbutton, leftbutton, rightbutton, firebutton;
let isMovingLeft, isMovingRight, isFire;


class Preload {
    preload() {
        this.load.image('clouds', 'assets/images/clouds.jpg');
        this.load.image('darkgreen', 'assets/images/darkgreen.png');
        this.load.image('green', 'assets/images/green.png');
        this.load.image('bullet', 'assets/images/bullet.png');
        this.load.image('mariotiles', 'assets/images/mariotiles.png');
        this.load.image('fireball', 'assets/images/fireball-small.png');
        this.load.image('coins', 'assets/images/coin.png');
        this.load.image('platform', 'assets/images/platformneu.png');
        this.load.image('flag', 'assets/images/flagneu.png');
        this.load.image('reloadbutton', 'assets/images/reloadbutton.png');
        this.load.image('menubutton', 'assets/images/menuebutton.png');
        this.load.image('jumpbutton', 'assets/jump_button.png');
        this.load.image('leftbutton', 'assets/left_button.png');
        this.load.image('rightbutton', 'assets/right_button.png');
        this.load.image('firebutton', 'assets/fire_button.png');

        this.load.audio('jumpsound', 'assets/music/jumpnew.ogg');
        this.load.audio('coinsound', 'assets/music/coinnew.ogg');
        this.load.audio('theme', 'assets/music/mariothemenew.ogg');
        this.load.audio('lose', 'assets/music/losenew.ogg');
        this.load.audio('clear', 'assets/music/stageclearnew.ogg');
        this.load.audio('kick', 'assets/music/kicknew.ogg');
        this.load.audio('fireball', 'assets/music/fireballnew.ogg');
        this.load.audio('savepoint', 'assets/music/savepointnew.ogg');

        this.load.spritesheet('button', 'assets/spritesheets/levelbutton.png', { frameWidth: 64, frameHeight: 64 });
        this.load.spritesheet('bricks', 'assets/spritesheets/bricks.png', { frameWidth: 32, frameHeight: 32 });
        this.load.spritesheet('buttons', 'assets/spritesheets/buttons.png', { frameWidth: 64, frameHeight: 64 });
        this.load.spritesheet('mario', 'assets/spritesheets/mario-animation-basic.png', { frameWidth: 30, frameHeight: 30 });

        this.load.tilemapTiledJSON('map', 'assets/level1.json');
        //     this.load.tilemapTiledJSON('map2', 'assets/level2.json');

    }
    create() {
        music = this.sound.add('theme', { loop: true });
        music.setVolume(1);
        jumpsound = this.sound.add('jumpsound');
        jumpsound.setVolume(1);
        stageclear = this.sound.add('clear');
        stageclear.setVolume(1);
        death = this.sound.add('lose');
        death.setVolume(1);
        coinsound = this.sound.add('coinsound');
        coinsound.setVolume(1);
        // this.scene.start("menu"); // MENU doesnt work --> Switching to level 1
        this.scene.start("menu");
    }
}

// import {Menue} from './menue.js';
class Menu {
    create() {
        //Menuselection
        clouds = this.add.tileSprite(0, 0, game.config.width * 2, game.config.height * 2, 'clouds').setOrigin(0, 0);
        this.add.text(260, game.config.height / 5.0, messages.menu_header, { fontSize: '32px', fill: '#000' });
        this.add.text(100, game.config.height / 3.6, messages.menu_sub, { fontSize: '30px', fill: '#000' });
        this.add.text(game.config.width / 2.9, game.config.height / 1.45, messages.menu_level1, { fontSize: '28px', fill: '#000' });
        this.add.text(game.config.width / 1.8, game.config.height / 1.45, messages.menu_level2, { fontSize: '28px', fill: '#000' });
        this.add.text(game.config.width / 2, game.config.height / 1.3, messages.nan, { fontSize: '28px', fill: 'red' });

        //Levelbuttons
        var levelbutton1 = this.add.sprite(400, 270, 'button').setInteractive();
        var levelbutton2 = this.add.sprite(600, 270, 'button').setInteractive();
        levelbutton1.on('pointerdown', function () {
            game.scene.stop("menu");
            // openFullScreenMode();
            game.scene.start("level1");
        });
        levelbutton1.on('pointerover', function () { this.setTint(config.hovercolor); });
        levelbutton1.on('pointerout', function () { this.clearTint(); });

        levelbutton2.on('pointerdown', function () {
            console.log(messages.notavailable)
        });
        levelbutton2.on('pointerover', function () { this.setTint(config.hovercolor); });
        levelbutton2.on('pointerout', function () { this.clearTint(); });
    }
}
class Level1 {

    create() {
        level = this;
        if (!music.isPlaying) { music.play(); }

        //tilemap, layer and backgrounds
        map = this.make.tilemap({ key: 'map' }); //erstellt die Tilemap mit dem Namen Map

        //backgroud wird konfiguriert
        clouds = this.add.tileSprite(0, 0, map.widthInPixels, map.heightInPixels, 'clouds').setOrigin(0, 0);
        green = this.add.tileSprite(0, map.heightInPixels - 540, map.widthInPixels, 640, 'green').setOrigin(0, 0);
        darkgreen = this.add.tileSprite(0, map.heightInPixels - 480, map.widthInPixels, 480, 'darkgreen').setOrigin(0, 0);

        //Layer werden erstellt
        var floorTiles = map.addTilesetImage('mariotiles');
        var floorLayer = map.createLayer('boden', floorTiles, 0, 0);
        floorLayer.setCollisionBetween(1, 400);
        var backgroundLayer = map.createLayer('hintergrund', floorTiles, 0, 0);
        var enemyLayer = map.createLayer('enemy', floorTiles, 0, 0);
        enemyLayer.setCollisionBetween(1, 400); // It is possible to collide with all enemy layer
        // enemyLayer.setTileIndexCallback([7, 8, 43, 44], playerDie, this); //tilesprite number

        //Konfiguration der Weltgrenze
        this.physics.world.setBounds(0, 0, map.widthInPixels, map.heightInPixels, 128, true, true, false, true);
        camera = this.cameras.main;
        camera.setBounds(0, 0, map.widthInPixels, map.heightInPixels);

        //mario settings
        mario = this.physics.add.sprite(40, map.heightInPixels - 250, 'mario');
        mario.setCollideWorldBounds(true);
        mario.body.setCircle(14);
        mario.setFlipX(true);
        mario.body.setMaxVelocity(500, 1000);  //the player will fall through plattforms if gravity is accelerating it to more than 1000px/s

        //flag settings
        flag = this.physics.add.sprite(map.widthInPixels - 120, map.heightInPixels - 130, 'flag');
        flag.body.allowGravity = false;
        flag.body.immovable = true;
        flag.setSize(10, 160);
        flag.setOffset(46, 10);

        camera.startFollow(mario, true, 0.05, 0.05)
        this.anims.create({
            key: 'walk',
            frames: this.anims.generateFrameNumbers('mario', { frames: [0, 1, 2, 3, 4, 3, 2, 1] }),
            frameRate: 16
        });

        //movingplatforms
        var movingplatform1 = this.physics.add.image(300, 300, 'platform')
        movingplatform1.body.setImmovable(true).setAllowGravity(false);

        this.tweens.add({
            targets: movingplatform1,
            y: 200,
            duration: 1000,
            ease: 'Sine.easeInOu',
            yoyo: true,
            repeat: -1,
        });

        // Coins & collecting settings
        coins = this.physics.add.group({
            key: 'coins',
            repeat: 20,
            setXY: { x: 100, y: 100, stepX: 160 }
        });
        coins.children.iterate(function (child) {
            child.setBounceY(Phaser.Math.FloatBetween(0.4, 0.8));
            child.setSize(25, 25, true);      // The 'true' argument means "center it on the gameobject"
            child.setScale(0.5);
        });
        scoreText = this.add.text(16, 16, messages.score_message, { fontSize: '22px', fill: '#000' });
        scoreText.setScrollFactor(0);

        failsCounter = this.add.text(16, 40, messages.failscounter_message + fails, { fontSize: '22px', fill: '#000' });
        failsCounter.setScrollFactor(0);

        jumpsCounter = this.add.text(16, 64, messages.jumpscounter_message + jumps, { fontSize: '22px', fill: '#000' });
        jumpsCounter.setScrollFactor(0);

        //controls and camera
        cursors = this.input.keyboard.createCursorKeys();
        keyboardA = this.input.keyboard.addKey('A');
        keyboardD = this.input.keyboard.addKey('D');
        jumpkey2 = this.input.keyboard.addKey('W');
        // shootkey1 = this.input.keyboard.addKey('F');
        // shootkey2 = this.input.keyboard.addKey('M');
        jumpkey = this.input.keyboard.addKey(Phaser.Input.Keyboard.KeyCodes.SPACE);

        // collider settings
        this.physics.add.collider(mario, platform);
        this.physics.add.collider(mario, floorLayer);
        this.physics.add.collider(mario, movingplatform1, mptouchedown);
        this.physics.add.collider(mario, enemyLayer, playerDie, null, this); // Call die function when mario collides with enemyLayerItem
        // this.physics.add.collider(mario, enemyLayer);
        this.physics.add.collider(coins, floorLayer);

        // overlap checks need to be made after colliders
        // object1, object2, collideCallback, processCallback, callbackContext)
        this.physics.add.overlap(mario, enemyLayer, null, null, this);
        this.physics.add.overlap(mario, flag, finishedlastlevel, null, this);
        this.physics.add.overlap(mario, coins, collectCoins, null, this);

        // mobile functionality

        // Jump button setup
        jumpbutton = this.add.sprite(config.canvas.width - 70, config.canvas.height - 50, 'jumpbutton').setInteractive();
        jumpbutton.on('pointerdown', function () {
            jump();
        }).on('pointerup', function () {

        });
        jumpbutton.setScrollFactor(0);

        // Left move button setup
        leftbutton = this.add.sprite(config.leftRightButtonPosition, config.canvas.height - 50, 'leftbutton').setInteractive();
        leftbutton.on('pointerdown', function () {
            isMovingLeft = true;
        }).on('pointerup', function () {
            isMovingLeft = false;
        });
        leftbutton.setScrollFactor(0);

        // Right move button setup
        rightbutton = this.add.sprite(config.leftRightButtonPosition + leftbutton.width, config.canvas.height - 50, 'rightbutton').setInteractive();
        rightbutton.on('pointerdown', function () {
            isMovingRight = true;
        }).on('pointerup', function () {
            isMovingRight = false;
        });
        rightbutton.setScrollFactor(0);

        // TODO firebutton

        //reloadbutton
        var reloadbutton = this.add.sprite(900, 32, 'reloadbutton').setInteractive();
        reloadbutton.setScrollFactor(0);
        reloadbutton.on('pointerdown', function () {
            restartGame();
        });
        reloadbutton.on('pointerover', function () { this.setTint(config.hovercolor); });
        reloadbutton.on('pointerout', function () { this.clearTint(); });

        //homebutton
        var menubutton = this.add.sprite(970, 32, 'menubutton').setInteractive();
        menubutton.setScrollFactor(0);
        menubutton.on('pointerdown', function () {
            stopGame();
        });
        menubutton.on('pointerover', function () { this.setTint(config.hovercolor); });
        menubutton.on('pointerout', function () { this.clearTint(); });
    }



    update() {
        //läuft nach links
        if (cursors.left.isDown || keyboardA.isDown || isMovingLeft) {
            mario.anims.play('walk', true);
            mario.setFlipX(false);
            mario.setVelocityX(config.moveLeftVelocity);
        }
        //läuft nach rechts
        else if (cursors.right.isDown || keyboardD.isDown || isMovingRight) {
            mario.anims.play('walk', true);
            mario.setVelocityX(config.moveRightVelocity);
            mario.setFlipX(true);
        }
        //wenn nicht - keine Geschwindigkeit & Bild 3
        else {
            mario.setVelocityX(0);
            mario.setFrame(3);
        }

        if (Phaser.Input.Keyboard.JustDown(jumpkey) || Phaser.Input.Keyboard.JustDown(jumpkey2) || Phaser.Input.Keyboard.JustDown(cursors.up)) {
            jump();
        }

        //wenn nicht am Boden und Jump - 5. Frame
        if (!onFloor() && jumpkey.isDown || !onFloor() && jumpkey2.isDown || !onFloor() && cursors.up.isDown) { mario.setFrame(5); }
        if (mario.body.y > map.heightInPixels) { playerDie(); }

        // if (shootkey1.isDown || shootkey2.isDown) {
        //     shoot();
        // }

        // parallax
        green.x = camera.scrollX * 0.5;
        darkgreen.x = camera.scrollX * 0.3;
        clouds.x = camera.scrollX * 0.8;
    }
}

class Level2 { }

class FinishedLevel {
    create() {
        clouds = this.add.tileSprite(0, 0, game.config.width * 2, game.config.height * 2, 'clouds').setOrigin(0, 0);
        var scoreText = this.add.text(game.config.width / 2, game.config.height / 3, messages.title_won, { fontSize: '32px', fill: '#000' });
        this.add.text(game.config.width / 6, game.config.height / 1.7, messages.title_won_sub, { fontSize: '32px', fill: '#000' });
        scoreText.x -= scoreText.width / 2; // why do we use that? (TODO)

        music.stop()
        stageclear.play();
        this.time.delayedCall(5500, nextlevel1, [], this)
    }
}

class FinishedLastLevel {
    create() {
        clouds = this.add.tileSprite(0, 0, game.config.width * 2, game.config.height * 2, 'clouds').setOrigin(0, 0);
        var scoreText = this.add.text(game.config.width / 2, game.config.height / 3.5, messages.title_won_all, { fontSize: '32px', fill: '#000' });
        this.add.text(game.config.width / 2.8, game.config.height / 1.6, messages.title_won_all_sub, { fontSize: '32px', fill: '#000' });
        this.add.text(game.config.width / 7.0, game.config.height / 1.3, messages.reload, { fontSize: '28px', fill: '#000' });
        scoreText.x -= scoreText.width / 2; //do we really need that? (TODO)

        music.stop()
        stageclear.play();
        this.time.delayedCall(5500, backToMenu, [], this)
    }
}

//mario dies - Settings
function playerDie() {
    death.play();
    incrementFails();
    restartGame();
}

function restartGame() {
    level.scene.restart();
    music.stop();
    resetVariables(false);
}

function stopGame() {
    resetVariables(true);
    music.stop();
    level.scene.stop();
    game.scene.start("menu");
    // closeFullScreenMode();
}

function shoot() {
    console.log("Success");

}

// Setzt die Variablen zurück
function resetVariables(resetCounter) {
    if (resetCounter) {
        score = 0;
        fails = 0;
        jumps = 0;
    }
    isMovingLeft = false;
    isMovingRight = false;
    isFire = false;
}

function jump() {
    if (isValidJump()) {
        mario.body.velocity.y = config.jumpheight;
        incrementJumps();
        jumpsound.play();
        counter++;
    }
}

function isValidJump() {
    if (isOnFloor() || counter <= 1) {
        return true;
    }
    return false;
}

function isOnFloor() {
    if (mario.body.onFloor() || mario.body.touching.down) {
        counter = 0;
        return true;
    }
    return false;
}

//action to start the next level after 5500ms
function nextlevel1() {
    this.scene.stop("finished");
    this.scene.start("level1");
}

// action to move back to menu after last level
function backToMenu() {
    this.scene.stop();
    this.scene.start("menu");
}

//action if level has been finished
function finishedlevel() {
    this.scene.stop();
    this.scene.start("finishedlevel");

}

//action to stop the lastlevel
function finishedlastlevel() {
    this.scene.stop();
    this.scene.start("finishedlastlevel");

}

//platforms collider
function mptouchedown(mplayer, mplatform) {
    if (mplatform.body.touching.up && mplayer.body.touching.down) {
        mplayer.body.blocked.down = true;
    }
}

//coins collecting
function collectCoins(mario, coins) {
    coins.disableBody(true, true);
    score += config.scoreadditionvalue;
    scoreText.setText('Score: ' + score + ' points');
    coinsound.play();
}

// fails counter
function incrementFails() {
    fails += 1;
    failsCounter.setText(messages.failscounter_message + fails);
}

//jumps counter
function incrementJumps() {
    jumps += 1;
    jumpsCounter.setText(messages.jumpscounter_message + jumps);
}

function onFloor() {
    mario.body.onFloor();
}

function openFullScreenMode() {
    game.scale.startFullscreen();
}

function closeFullScreenMode() {
    game.scale.stopFullscreen();
}

// Volumeslider
window.volumeslider = function () {
    let division1 = 150;
    let volume = document.getElementById("volumeslider");
    console.debug(`Volume Value: ${volume.value}`)
    if (mutevalue == 0) {
        console.debug("success!")
        music.volume = volume.value / division1;
        jumpsound.volume = volume.value / division1;
        stageclear.volume = volume.value / division1;
        death.volume = volume.value / division1;
        coinsound.volume = volume.value / division1;
    }
    else {
        console.debug("Music is disabled!")
    }

}

// Mutebutton
window.mute = function () {
    // document.querySelector('#mute').addEventListener('click', mute)
    let checkBox = document.getElementById("mute");
    if (checkBox.checked == true) {
        music.pause();
        jumpsound.pause();
        stageclear.pause();
        death.pause();
        coinsound.pause();
        mutevalue = 1;
    }
    else {
        music.resume();
        jumpsound.resume();
        stageclear.resume();
        death.resume();
        coinsound.resume();
        mutevalue = 0;
    }

}

var game = new Phaser.Game(config.canvas);  //main game instance - using the config object
game.scene.add("level1", Level1);
game.scene.add("level2", Level2);
game.scene.add("finishedlevel", FinishedLevel);
game.scene.add("finishedlastlevel", FinishedLastLevel);
game.scene.add("preload", Preload);
game.scene.add("menu", Menu);
game.scene.start("preload");

//Version Control - 5.3.0
