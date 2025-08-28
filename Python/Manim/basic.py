from manim import *

class RotatingCube(ThreeDScene):
    def construct(self):
        # Set up the camera
        self.set_camera_orientation(phi=75 * DEGREES, theta=-45 * DEGREES)
        
        # Create a cube with semi-transparent faces
        cube = Cube(side_length=2, fill_opacity=0.3, stroke_width=2)
        
        try:
            # Load the Firebase logo
            logo = SVGMobject("firebase.svg")
            logo.scale(0.3)  # Scale to fit on the cube face
            
            # Create a white background for the logo
            logo_background = Square(side_length=1.8, fill_opacity=0.8, fill_color=WHITE, stroke_width=0)
            logo_group = VGroup(logo_background, logo).move_to(OUT * 1.01)  # Slightly in front of the cube
            
            # Add everything to the scene
            self.add(cube, logo_group)
            
            # Animation
            self.begin_ambient_camera_rotation(rate=0.5)  # Slowly rotate the camera
            
            # Make the logo face the camera
            def update_logo(logo_group, dt):
                # Get the camera's position in the scene
                camera_point = self.camera.get_center()
                # Make the logo look at the camera
                logo_group.look_at(camera_point)
                # Keep the logo at the front of the cube
                logo_group.move_to(cube.get_center() + cube.get_center() - camera_point)
            
            # Add the update function to the logo group
            logo_group.add_updater(update_logo)
            
            # Rotate the cube
            self.play(
                Rotate(cube, angle=2*PI, axis=UP + RIGHT, about_point=ORIGIN, rate_func=linear),
                run_time=8
            )
            
            # Stop the camera rotation
            self.stop_ambient_camera_rotation()
            self.wait(2)
            
        except Exception as e:
            # Fallback in case of any errors
            error_text = Text("Error loading SVG file\nPlease make sure 'firebase.svg' is in the same directory", 
                            font_size=24, color=RED)
            self.play(Write(error_text))
            self.wait(3)
