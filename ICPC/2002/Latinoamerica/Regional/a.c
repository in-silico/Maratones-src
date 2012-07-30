#include <stdio.h>


int ai_clock[] = {0, 0, 2, 2};
int aj_clock[] = {0, 2, 2, 0};

int bi_clock[] = {0, 1, 2, 1};
int bj_clock[] = {1, 2, 1, 0};


int ai_counter[] = {2, 2, 0, 0};
int aj_counter[] = {0, 2, 2, 0};

int bi_counter[] = {1, 2, 1, 0};
int bj_counter[] = {0, 1, 2, 1};


char faces[7][3][3];


int count_lines[] = {3, 3, 3, 12, 12, 12, 3, 3, 3};
int input[9][12][3];


int rot_face(int face, int rot){
  char tmp;
  int *i, *j;
  int k, k2;

  if (rot > 0){
    i = ai_clock;
    j = aj_clock;
  }else{
    i = ai_counter;
    j = aj_counter;
  }

  for(k2=0; k2 < 2; k2++){
    tmp = faces[face][i[3]][j[3]];
    
    for(k=3; k > 0; k--){
      fflush(stdout);
      faces[face][i[k]][j[k]] = faces[face][i[k-1]][j[k-1]];
    }
    
    faces[face][i[0]][j[0]] = tmp;
    
    if(rot > 0){
      i = bi_clock;
      j = bj_clock;
    }else{
      i = bi_counter;
      j = bj_counter;
    }
  }
  return 0;
}


int get_row(int face, int row, int line[3]){
  int i;

  for(i=0; i < 3; i++)
    line[i] = faces[face][row][i];
  return 0;
}


int set_row(int face, int row, int line[3]){
  int i;

  for(i=0; i < 3; i++)
    faces[face][row][i] = line[i];
  return 0;
}


int get_column(int face, int column, int line[3]){
  int i;

  for(i=0; i < 3; i++)
    line[i] = faces[face][i][column];
  return 0;
}


int set_column(int face, int column, int line[3]){
  int i;

  for(i=0; i < 3; i++)
    faces[face][i][column] = line[i];
  return 0;
}


int invert(int line[3]){
  int i, tmp;

  tmp = line[0];
  line[0] = line[2];
  line[2] = tmp;
}

int rotation(int face){
  int rot;
  int line[3], tmp[3];

  if(face < 0){
    rot = -1;
    face *= -1;
  }else{
    rot = 1;
  }


  rot_face(face, rot);

  if(rot > 0){
    switch(face){
    case 1:
      get_column(5,0,tmp);
      
      get_column(4,2,line);
      invert(line);
      set_column(5,0,line);
      
      get_column(6,0,line);
      invert(line);
      set_column(4,2,line);

      get_column(2,0,line);
      set_column(6,0,line);

      set_column(2,0,tmp);
      break;

    case 2:
      get_row(5,2,tmp);

      get_column(1,2,line);
      invert(line);
      set_row(5,2,line);

      get_row(6,0,line);
      set_column(1,2,line);

      get_column(3,0,line);
      invert(line);
      set_row(6,0,line);

      set_column(3,0,tmp);
      break;

    case 3:
      get_column(6,2,tmp);
      
      get_column(4,0,line);
      invert(line);
      set_column(6,2,line);

      get_column(5,2,line);
      invert(line);
      set_column(4,0,line);

      get_column(2,2,line);
      set_column(5,2,line);
      
      set_column(2,2,tmp);
      break;

    case 4:
      get_column(3,2,tmp);

      get_row(6,2,line);
      invert(line);
      set_column(3,2,line);

      get_column(1,0,line);
      set_row(6,2,line);

      get_row(5,0,line);
      invert(line);
      set_column(1,0,line);

      set_row(5,0,tmp);
      break;

    case 5:
      get_row(1,0,tmp);

      get_row(2,0,line);
      set_row(1,0,line);

      get_row(3,0,line);
      set_row(2,0,line);

      get_row(4,0,line);
      set_row(3,0,line);

      set_row(4,0,tmp);
      break;

    case 6:
      get_row(4,2,tmp);

      get_row(3,2,line);
      set_row(4,2,line);

      get_row(2,2,line);
      set_row(3,2,line);

      get_row(1,2,line);
      set_row(2,2,line);

      set_row(1,2,tmp);
      break;
    }
  }else{
    switch(face){
    case 1:
      get_column(6,0,tmp);

      get_column(4,2,line);
      invert(line);
      set_column(6,0,line);
      
      get_column(5,0,line);
      invert(line);
      set_column(4,2,line);

      get_column(2,0,line);
      set_column(5,0,line);

      set_column(2,0, tmp);
      break;

    case 2:
      get_column(1,2,tmp);

      get_row(5,2,line);
      invert(line);
      set_column(1,2,line);

      get_column(3,0,line);
      set_row(5,2,line);

      get_row(6,0,line);
      invert(line);
      set_column(3,0,line);

      set_row(6,0,tmp);
      break;

    case 3:
      get_column(5,2,tmp);

      get_column(4,0,line);
      invert(line);
      set_column(5,2,line);

      get_column(6,2,line);
      invert(line);
      set_column(4,0,line);

      get_column(2,2,line);
      set_column(6,2,line);

      set_column(2,2,tmp);
      break;

    case 4:
      get_row(6,2,tmp);

      get_column(3,2,line);
      invert(line);
      set_row(6,2,line);

      get_row(5,0,line);
      set_column(3,2,line);

      get_column(1,0,line);
      invert(line);
      set_row(5,0,line);

      set_column(1,0,tmp);
      break;

    case 5:
      get_row(4,0,tmp);

      get_row(3,0,line);
      set_row(4,0,line);

      get_row(2,0,line);
      set_row(3,0,line);

      get_row(1,0,line);
      set_row(2,0,line);

      set_row(1,0,tmp);
      break;

    case 6:
      get_row(1,2,tmp);

      get_row(2,2,line);
      set_row(1,2,line);

      get_row(3,2,line);
      set_row(2,2,line);

      get_row(4,2,line);
      set_row(3,2,line);

      set_row(4,2,tmp);
      break;
    }
  }
}


int read_faces(){
  char line[1000];
  int i, j, k;
  int f, r, c;
  for(i=0; i < 9; i++){
    scanf("%[ YBRGWM]s", &line);
    k = 0;
    for(j=0; k < count_lines[i]; j++){
      if(line[j] == ' ')
        continue;
      f = input[i][k][0];
      r = input[i][k][1];
      c = input[i][k][2];
      faces[f][r][c] = line[j];
      k ++;
    }
    getchar();
  }

  return 0;
}
 

int show_face(int face){
  int i, j; 

  printf("---\n");
  for(i=0; i < 3; i++)
    for(j=0; j < 3; j++)
      printf("%c%c", faces[face][i][j], j == 2 ? '\n' : ' ');
  printf("---\n");
  return 0;
}

int verify(){
  int i, j, k;
  char c;

  for(i=1; i <= 6; i++){
    c = faces[i][0][0];
    for(j=0; j < 3; j++){
      for(k=0; k < 3; k++){
        if (faces[i][j][k] != c){
          return 1;
        }
      }
    }
  }
  return 0;
}


int main(){
  int t, face;
  int i , j;

  for(i=0; i < 3; i++){ for(j=0; j < 3; j++){ input[i][j][0] = 5; input[i][j][1] = i; input[i][j][2] = j; } }

  for(i=3; i < 6; i++){
    for(j=0; j <  3; j++){ input[i][j][0] = 1; input[i][j][1] = i-3; input[i][j][2] = j;   }
    for(j=3; j <  6; j++){ input[i][j][0] = 2; input[i][j][1] = i-3; input[i][j][2] = j-3; }
    for(j=6; j <  9; j++){ input[i][j][0] = 3; input[i][j][1] = i-3; input[i][j][2] = j-6; }
    for(j=9; j < 12; j++){ input[i][j][0] = 4; input[i][j][1] = i-3; input[i][j][2] = j-9; }
  }

  for(i=6; i < 9; i++){ for(j=0; j < 3; j++){ input[i][j][0] = 6; input[i][j][1] = i-6; input[i][j][2] = j; } }


  scanf("%d", &t);
  while(t--){
    getchar();
    read_faces();
    while(scanf("%d", &face) && face){
      rotation(face);
    }
    if(!verify())
      printf("Yes, grandpa!\n");
    else
      printf("No, you are wrong!\n");
  }


  return 0;
}
