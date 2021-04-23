import java.util.*;
public class Talkies {
    UserInterface ui = new UserInterface();
    Random rand = new Random();
    int currentDay = 0;

    private String lonely = "No one wants to talk to you today.";
    private String fact1 = "True to its namesake (the speedy messenger of ancient Roman gods), Mercury is the fastest planet in our solar system. It zips around our Sun at an average of 172,000 kilometers per hour (107,000 miles per hour) — about 65,000 kph (40,000 mph) faster than Earth. A year on Mercury is equal to 88 Earth days.";
    private String fact2 = "Neptune’s winds are the fastest in the solar system, reaching 2,575 kilometers per hour (1,600 miles per hour)! Neptune’s giant, spinning storms could swallow the whole Earth.";
    private String fact3 = "Saturn is the only planet in our solar system that is less dense than water. It could float in a bathtub if anybody could build a bathtub big enough.";
    private String fact4 = "Saturn is the flattest planet. Its polar diameter is 90% of its equatorial diameter, this is due to its low density and fast rotation. Saturn turns on its axis once every 10 hours and 34 minutes giving it the second-shortest day of any of the solar system’s planets.";
    private String fact5 = "Saturn has 150 moons and smaller moonlets. All are frozen worlds. The largest moons are Titan and Rhea. Enceladus appears to have an ocean below its frozen surface.";
    private String fact6 = "Ganymede is the largest moon in the solar system, and is larger than the planet Mercury. If it were not orbiting as Jupiter’s largest moon, it could be considered a dwarf planet.";
    private String fact7 = "Ganymede has a thin atmosphere that appears to contain oxygen. This was confirmed by Hubble Space Telescope observations. The oxygen is likely freed as water ice on the surface is broken apart into hydrogen and oxygen by solar radiation.";
    private String fact8 = "Jupiter’s moon Ganymede is the largest moon in the solar system. Jupiter’s moons are sometimes called the Jovian satellites, the largest of these are Ganymeade, Callisto Io and Europa. Ganymeade measures 5,268 km across, making it larger than the planet Mercury.";
    private String fact9 = "Jupiter’s interior is made of rock, metal, and hydrogen compounds. Below Jupiter’s massive atmosphere (which is made primarily of hydrogen), there are layers of compressed hydrogen gas, liquid metallic hydrogen, and a core of ice, rock, and metals.";
    private String moonFact1 = "Craters at the Moon’s south pole may be the frostiest locale in the entire solar system. In the permanently shadowed crater floors, “daytime” temperatures may never rise above minus 238 degrees Celsius (minus 397 degrees Fahrenheit).";
    private String moonFact2 = "The Moon is drifting away from the Earth. The Moon is moving approximately 3.8 cm away from our planet every year. It is estimated that it will continue to do so for around 50 billion years. By the time that happens, the Moon will be taking around 47 days to orbit the Earth instead of the current 27.3 days.";
    private String moonFact3 = "The Moon has quakes. These are caused by the gravitational pull of the Earth. Lunar astronauts used seismographs on their visits to the Moon, and found that small moonquakes occurred several kilometres beneath the surface, causing ruptures and cracks. Scientists think the Moon has a molten core, just like Earth.";
    private String moonFact4 = "The Moon is the fifth largest natural satellite in the Solar System. At 3,475 km in diameter, the Moon is much smaller than the major moons of Jupiter and Saturn. Earth is about 80 times the volume than the Moon, but both are about the same age. A prevailing theory is that the Moon was once part of the Earth, and was formed from a chunk that broke away due to a huge object colliding with Earth when it was relatively young.";
    private String moonFact5 = "During the 1950’s the USA considered detonating a nuclear bomb on the Moon. The secret project was during the height cold war was known as “A Study of Lunar Research Flights” or “Project A119” and meant as a show of strength at a time they were lagging behind in the space race.";
    private String marsFact1 = "The largest canyon system in the solar system is Valles Marineris on Mars. It’s more than 4,000 kilometers (3,000 miles) long — enough to stretch from California to New York. It is nine times as long and four times as deep as Earth’s Grand Canyon!";
    private String marsFact2 = "If you could stand at the Martian equator, the temperature at your feet would be like a warm spring day, but at your head it would be freezing cold!";
    private String marsFact3 = "Olympus Mons, a shield volcano, is 21km high and 600km in diameter. Despite having formed over billions of years, evidence from volcanic lava flows is so recent many scientists believe it could still be active.";
    private String marsFact4 = "Mars has the largest dust storms in the solar system. They can last for months and cover the entire planet. The seasons are extreme because its elliptical (oval-shaped) orbital path around the Sun is more elongated than most other planets in the solar system.";
    private String marsFact5 = "One day Mars will have a ring. In the next 20-40 million years Mars’ largest moon Phobos will be torn apart by gravitational forces leading to the creation of a ring that could last up to 100 million years.";
    private String beltFact1 = "Ceres is the largest, most massive body in the main asteroid belt between Mars and Jupiter, totaling about a third of the total mass of the entire belt. But Ceres is the smallest of the dwarf planets, which include Pluto and Eris, and the only dwarf planet that resides in the asteroid belt";
    private String beltFact2 = "If you could lump together all the thousands of known asteroids in our solar system, their total mass wouldn’t even equal 10 percent of the mass of Earth’s Moon.in the asteroid belt";
    private String beltFact3 = "The Asteroid Belt is often referred to as the “Main Belt” to distinguish it from other groups of asteroids such as the Lagrangians and Centaurs.";
    
    
    public void pickATalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    ui.println(fact1);
                    break;
                case 2:
                    ui.println(fact2);
                    break;
                case 3:
                    ui.println(fact3);
                    break;
                case 4:
                    ui.println(fact4);
                    break;
                case 5:
                    ui.println(fact5);
                    break;
                case 6:
                    ui.println(fact6);
                    break;
                case 7:
                    ui.println(fact7);
                    break;
                case 8:
                    ui.println(fact8);
                    break;
                case 9:
                    ui.println(fact9);
                    break;
                default:
                    ui.println(lonely);
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }

    public void pickAMoonTalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    ui.println(moonFact1);
                    break;
                case 2:
                    ui.println(moonFact2);
                    break;
                case 3:
                    ui.println(moonFact3);
                    break;
                case 4:
                    ui.println(moonFact4);
                    break;
                case 5:
                    ui.println(moonFact5);
                    break;
                case 6:
                    ui.println(fact8);
                    break;
                case 7:
                    ui.println(fact8);
                    break;
                case 8:
                    ui.println(fact8);
                    break;
                case 9:
                    ui.println(fact8);
                    break;
                default:
                    ui.println(lonely);
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }

    public void pickAMarsTalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    ui.println(marsFact1);
                    break;
                case 2:
                    ui.println(marsFact2);
                    break;
                case 3:
                    ui.println(marsFact3);
                    break;
                case 4:
                    ui.println(marsFact4);
                    break;
                case 5:
                    ui.println(marsFact5);
                    break;
                case 6:
                    ui.println(fact8);
                    break;
                case 7:
                    ui.println(fact8);
                    break;
                case 8:
                    ui.println(fact8);
                    break;
                case 9:
                    ui.println(fact8);
                    break;
                default:
                    ui.println(lonely);
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }
}